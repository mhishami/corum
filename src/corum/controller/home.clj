(ns corum.controller.home
  (:use compojure.core)
  (:require [corum.views.layout :as layout]))

(defn index-page []
  (layout/base "Home"
    [:div {:class "jumbotron"}
      [:h1 "Hello"]
      [:p {:class "lead"} "Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus"]
      [:p [:a {:class "btn btn-lg btn-success" :href "#" :role "button"} "Sign-Up Today"]]]
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