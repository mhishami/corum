(ns corum.controller.home
  (:use compojure.core)
  (:require [corum.views.template :as template]
            [taoensso.timbre :as timbre]))
(timbre/refer-timbre) ;; provide aliases for timbre

(defn home-page []
  (template/render "home/home.html"))

(defn contact-page []
  (template/render "home/contact.html"))

(defn about-page []
  (template/render "home/about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/contact" [] (contact-page))
  (GET "/about" [] (about-page)))