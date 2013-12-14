(ns corum.controller.auth
  (:use [compojure.core]
        [hiccup.form])
  (:require [corum.views.layout :as layout]))


(defn login-page []
  (layout/base "Login"
    [:div {:class "row"}
      [:div {:class "col-md-8 col-md-offset-2"}
        [:h2 "Login"]
        (form-to [:post "/auth/login"]
          [:div {:class "form-group"}
           (label "email" "Email Address")
           (email-field {:class "form-control" :placeholder "Enter Email"} "email")]
          [:div {:class "form-group"}
           (label "password" "Password")
           (password-field {:class "form-control" :placeholder "Password"} "password")]
          (submit-button {:class "btn btn-success btn-default"} "Register") "&nbsp;"
          (reset-button {:class "btn"} "Reset"))]]
    [:br]))

(defn register-page []
  (layout/base "Register"
    [:div {:class "row"}
     [:div {:class "col-md-8 col-md-offset-2"}
      [:h2 "Register"]
      (form-to [:post "/auth/register"]
       [:div {:class "form-group"}
        (label "email" "Email Address")
        (email-field {:class "form-control" :placeholder "Enter Email"} "email")]
       [:div {:class "form-group"}
         (label "password" "Password")
         (password-field {:class "form-control" :placeholder "Password"} "password")]
       [:div {:class "form-group"}
        (label "password2" "Password (Again)")
        (password-field {:class "form-control" :placeholder "Password"} "password2")]
       (submit-button {:class "btn btn-success btn-default"} "Register") "&nbsp;"
       (reset-button {:class "btn"} "Reset"))]]
    [:br]))

(defroutes auth-routes
  (GET "/auth/login" [] (login-page))
  (GET "/auth/register" [] (register-page)))
