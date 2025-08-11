(ns webproject.handler
  #_{:clj-kondo/ignore [:refer-all]}
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [webproject.views.start-page :refer [start-page]]
            [webproject.views.profile-page :refer [profile-page]]))

;; Start page should have a list of dating profile for lonely Warhammer 40k characters that are lonely
;; Clicking on a character will take us to that profile

(defroutes resources-routes
  (route/resources "/"))

(defroutes app-routes
  (GET "/" [] start-page)
  (GET "/profile/:id" [] profile-page)
  (route/not-found "Not Found"))

(def app
  (wrap-defaults (compojure.core/routes
                  resources-routes
                  app-routes) site-defaults))
