(ns corum.controller.auth
  (:use compojure.core)
  (:require [corum.views.layout :as layout]))


(defn login-page []
  (layout/base "Login"
    [:div {:class "row"}
      [:div {:class "col-md-8 col-md-offset-2"}
        [:form {:role "form" :method "post"}
          [:div {:class "form-group"}
            [:label {:for "email"} "Email Address"]
            [:input {:type "email" :class "form-control" :id "email" :name "email" :placeholder "Enter email"}]
          [:div {:class "form-group"}
            [:label {:for "password"} "Password"]
            [:input {:type "password" :class "form-control" :id "password" :name "password" :placeholder "Password"}]
          [:br]
          [:button {:type "submit" :class "btn btn-success btn-default"} "Submit"]]]]]]))

(defroutes auth-routes
  (GET "/auth/login" [] (login-page)))
