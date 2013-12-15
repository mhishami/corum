(ns corum.views.layout
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)]
        [taoensso.timbre :as timbre]))
(timbre/refer-timbre)

(defn base [data title & body]
  "Provide base page for our app"
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
        [:li {:class "active"} [:a {:href "/"} "Home"]]
        [:li [:a {:href "/about"} "About"]]
        [:li [:a {:href "/contact"} "Contact"]]
        (let [user (:userid data)]
          (if (nil? user)
            [:li [:a {:href "/auth/login"} "Login"]]
            [:li [:a {:href "/auth/logout" :class "btn btn-success"} "(" user ") Logout"]]))]
       [:h3 {:class "text-muted"} "Corum"]]
      body
      [:br]
      [:div {:class "footer"}
       [:p "&copy; 2013 Hisham Ismail. All rights Reserved."]]]]))

(defn with-title [title]
  [:h2 title])

(defn with-row [& body]
  [:div {:class "row"} body])

(defn with-dialog [& body]
  [:div {:class "col-md-8 col-md-offset-2"} body])

(defn with-form-group [& body]
  [:div {:class "form-group"} body])
