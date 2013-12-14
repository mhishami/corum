(ns corum.views.layout
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)]))

(defn base [title & body]
  (html5
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge"}]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
      (include-css "/assets/css/bootstrap.css"
                   "/assets/css/style.css")
      [:title title]]
    [:body
      [:div {:class "container"}
        [:div {:class "header"}
          [:ul {:class "nav nav-pills pull-right"}
            [:li {:class "active"} [:a {:href "#"} "Home"]]
            [:li [:a {:href "/about"} "About"]]
            [:li [:a {:href "/contact"} "Contact"]]
            [:li [:a {:href "/auth/login"} "Login"]]]
          [:h3 {:class "text-muted"} "Corum"]]
        body
        [:div {:class "footer"}
          [:p "&copy; 2013. Allrights Reserved."]]]
      ]))