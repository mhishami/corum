(ns corum.controller.home
  (:use compojure.core)
  (:require [corum.views.layout :as layout]
            [noir.session :as session]
            [taoensso.timbre :as timbre]))
(timbre/refer-timbre) ;; provide aliases for timbre

(defn index-page [user]
  (layout/base {:userid user}  "Home"
    [:div {:class "jumbotron"}
     [:h1 "Corum"]
     (if user [:h3 "Welcome " user])
     (if-not user [:h3 "Welcome anonymous"])
     [:p {:class "lead"} "Corum is a community driven forum application"]
     [:p [:a {:class "btn btn-lg btn-success" :href "/auth/register" :role "button"} "Sign-Up Today"]]]))

(defn contact-page [user]
  (layout/base {:userid user} "Contact"
    [:address
     [:strong "Corum Community"]
     [:br] "795 Folsom Ave, Suite 600"
     [:br] "San Francisco, CA 94107"
     [:br] [:abbr {:title "Phone"} "P:"] "(603) 123 4567" ]))

(defn about-page [user]
  (layout/base {:userid user} "About"
    [:div {:class "jumbotron"}
      [:h1 "About Corum"]
      [:p {:class "lead"} "Corum is a community driven forum application"
      [:p [:a {:class "btn btn-lg btn-success" :href "/" :role "button"} "Home"]]]]))

(defn wrap-page [page]
  (let [user (session/get :user-id)]
    (info "User is = " user)
    (page user)))

(defroutes home-routes
  (GET "/" [] (wrap-page index-page))
  (GET "/contact" [] (wrap-page contact-page))
  (GET "/about" [] (wrap-page about-page)))