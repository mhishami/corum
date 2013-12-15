(ns corum.controller.auth
  (:use [compojure.core]
        [hiccup.form]
        [hiccup.element])
  (:require [corum.views.layout :as layout]
            [noir.session :as session]
            [noir.response :as resp]
            [taoensso.timbre :as timbre]))
(timbre/refer-timbre) ;; provide aliases for timbre

(defn show-login []
  "Present the layout view for login page"
  (layout/base {} "Login"
    (layout/with-row
      (layout/with-dialog
        (layout/with-title "Login")
        (form-to [:post "/auth/login"]
          (layout/with-form-group
            (label "email" "Email Address")
            (email-field {:class "form-control" :placeholder "Enter Email"} "email"))
          (layout/with-form-group
            (label "password" "Password")
            (password-field {:class "form-control" :placeholder "Password"} "password"))
          (layout/with-form-group
            (submit-button {:class "btn btn-default btn-success"} "Login") "&nbsp;"
            (reset-button {:class "btn"} "Reset")))
        (link-to "/auth/register" "Register") " | "
        (link-to "/auth/reset" "Forgot password")
        ))))


(defn do-login [{:keys [email password]}]
  "Validate user credentials, and redirect to main page"
  (info "Username and password = " email password)
  (session/put! :user-id email)
  (info "Current session = " (session/get :user-id))
  (resp/redirect "/"))

(defn show-register []
  (layout/base {} "Register"
    (layout/with-row
      (layout/with-dialog
        (layout/with-title "Register")
        (form-to [:post "/auth/register"]
          (layout/with-form-group
            (label "email" "Email Address")
            (email-field {:class "form-control" :placeholder "Enter Email"} "email"))
          (layout/with-form-group
            (label "password" "Password")
            (password-field {:class "form-control" :placeholder "Password"} "password"))
          (layout/with-form-group
            (label "password2" "Password (Again)")
            (password-field {:class "form-control" :placeholder "Password again"} "password2"))
          (layout/with-form-group
            (submit-button {:class "btn btn-default btn-success"} "Register") "&nbsp;"
            (reset-button {:class "btn"} "Reset")))))))

(defn do-logout []
  (session/clear!)
  (resp/redirect "/"))

(defroutes auth-routes
  (GET "/auth/login" [] (show-login))
  (POST "/auth/login" {params :params} (do-login params))
  (GET "/auth/logout" [] (do-logout))
  (GET "/auth/register" [] (show-register)))
