(ns corum.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [noir.util.middleware :as middleware]
            [corum.controller.auth :refer [auth-routes]]
            [corum.controller.home :refer [home-routes]]
            [corum.views.layout :as layout]))

(defn not-found []
  (layout/base {} "Opps!!"
    [:div {:class "jumbotron"}
     [:h1 "Sorry!"]
     [:p {:class "lead"} "I cannot find the page you're looking for"
      [:p [:a {:class "btn btn-lg btn-success" :href "/" :role "button"} "Home"]]]]))

(defroutes app-routes
  (route/resources "/")
  (route/not-found (not-found)))

(def app
  (middleware/app-handler
    [auth-routes home-routes app-routes]
    :middleware []
    :access-rules []))