(ns corum.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [noir.util.middleware :as middleware]
            [corum.controller.auth :refer [auth-routes]]
            [corum.controller.home :refer [home-routes]]
            [corum.views.template :as template]))

(defn not-found []
  (template/render "error.html"))

(defroutes app-routes
  (route/resources "/")
  (route/not-found (not-found)))

(def app
  (middleware/app-handler
    [auth-routes home-routes app-routes]
    :middleware []
    :access-rules []))