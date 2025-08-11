(ns webproject.views.profile-page
  (:require [hiccup2.core :as h]
            [webproject.views.layouts.layouts :refer [layout-guest]]
            [webproject.data.data :refer [get-profile]]))

(defn profile-page [request]
  (let [id (:id (:params request))
        profile (get-profile (keyword id))]
    (layout-guest (h/html
                   [:div
                    {:class
                     "mx-auto overflow-hidden bg-white rounded-lg shadow-lg "}
                    [:div
                     {:class "relative"}
                     [:img
                      {:class "w-full h-88 object-cover",
                       :src
                       (:image profile)
                       :alt "Profile Image"}]]
                    [:div
                     {:class "px-6 py-4 text-center"}
                     [:div {:class "text-xl font-semibold text-gray-800"} (str (:name profile) ", " (:age profile))]
                     [:p {:class "text-gray-600"} (:description profile)]]
                    [:div
                     {:class "px-6 py-4 text-center"}
                     [:p {:class "text-gray-600 font-bold"} (:hobbies profile)]]
                    [:div
                     {:class "px-6 py-4"}]]))))
