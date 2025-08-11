(ns webproject.views.start-page
  (:require [hiccup2.core :as h]
            [webproject.views.layouts.layouts :refer [layout-guest]]
            [webproject.data.data :refer [all-profiles]]))

(defn profile-card [profile]
  (h/html
   [:div
    {:class
     "flex-shrink-0 m-6 relative overflow-hidden bg-orange-500 rounded-lg max-w-xs shadow-lg"}
    [:div
     {:class "relative pt-10 px-10 flex items-center justify-center"}
     [:div
      {:class "block absolute w-48 h-48 bottom-0 left-0 -mb-24 ml-3",
       :style
       {:background "radial-gradient(black, transparent 60%)",
        :transform "rotate3d(0, 0, 1, 20deg) scale3d(1, 0.6, 1)",
        :opacity "0.2"}}]
     [:img
      {:class "relative w-40",
       :src
       (:image profile)
       :alt ""}]]
    [:div
     {:class "relative text-white px-6 pb-6 mt-6"}

     [:a
      {:class "flex justify-center" :href (str "/profile/" (:id profile))}
      [:span {:class "block font-semibold  text-2xl"} (:name profile)]]]]))

(defn start-page [request]
  (layout-guest (h/html  [:div {:class "p-1 flex flex-wrap items-center justify-center"}
                          (for [profile (vals (all-profiles))]
                            [:div {:class "pb-4"} (profile-card profile)])])))
