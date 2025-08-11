(ns webproject.views.layouts.layouts
  (:require [hiccup2.core :as h]))

(defn layout-guest [html-response]
  (str (h/html [:html
                [:head
                 [:meta {:charset "UTF-8"}]
                 [:meta {:name "viewport", :content "width=device-width, initial-scale=1.0"}]
                 [:meta {:http-equiv "X-UA-Compatible", :content "ie=edge"}]
                 [:link {:href "/app.css" :rel "stylesheet"}]
                 [:title "Super amazing and impressive web project for extra gentlemany gentlemen"]]
                [:body
                 [:div {:class "flex flex-row min-h-screen justify-center items-center"}
                  html-response]]])))
