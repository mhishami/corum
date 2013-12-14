(ns corum.controller.home
  (:use compojure.core)
  (:require [corum.views.layout :as layout]))

(defn index-page []
  (layout/base "Home"
    [:div {:class "jumbotron"}
      [:h1 "Home"]
      [:p {:class "lead"} "Corum is a community driven forum application"]
      [:p [:a {:class "btn btn-lg btn-success" :href "/auth/register" :role "button"} "Sign-Up Today"]]]
    ))

(defn contact-page []
  (layout/base "Contact"
    [:address
     [:strong "Corum Community"]
     [:br] "795 Folsom Ave, Suite 600"
     [:br] "San Francisco, CA 94107"
     [:br] [:abbr {:title "Phone"} "P:"] "(603) 123 4567" ]))

(defn about-page []
  (layout/base "About"
    [:div {:class "jumbotron"}
      [:h1 "About Corum"]
      [:p {:class "lead"} "Corum is a community driven forum application"
      [:p [:a {:class "btn btn-lg btn-success" :href "/" :role "button"} "Home"]]]]))

(defroutes home-routes
  (GET "/" [] (index-page))
  (GET "/contact" [] (contact-page))
  (GET "/about" [] (about-page)))