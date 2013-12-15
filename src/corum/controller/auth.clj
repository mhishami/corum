(ns corum.controller.auth
  (:use [compojure.core])
  (:require [corum.views.template :as template]
            [noir.session :as session]
            [noir.response :as resp]
            [taoensso.timbre :as timbre]))
(timbre/refer-timbre) ;; provide aliases for timbre

(defn do-logout []
  (session/clear!)
  (resp/redirect "/"))

(defn login-page []
  (template/render "auth/login.html"))

(defn do-login [{:keys [email password]}]
  "Validate user credentials, and redirect to main page"
  (session/put! :user-id email)
  (resp/redirect "/"))

(defn register-page []
  (template/render "auth/register.html"))

(defn reset-page []
  (template/render "auth/reset.html"))

(defroutes auth-routes
  (GET "/auth/login" [] (login-page))
  (POST "/auth/login" {params :params} (do-login params))

  (GET "/auth/register" [] (register-page))

  (GET "/auth/reset" [] (reset-page))
  (GET "/auth/logout" [] (do-logout)))
