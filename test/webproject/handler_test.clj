(ns webproject.handler-test
  (:require [clojure.test :refer [deftest is testing]]
            [ring.mock.request :as mock]
            [webproject.handler :refer [app]]
            [clojure.string :as string]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (string/includes? (:body response) "Kharn the Betrayer"))
      (is (string/includes? (:body response) "Abadonn the Despoiler"))
      (is (string/includes? (:body response) "Robute Gulliman"))))

  (testing "profile route"
    (let [response (app (mock/request :get "/profile/1"))]
      (is (= (:status response) 200))
      (is (string/includes? (:body response) "Kharn the Betrayer"))
      (is (string/includes? (:body response) "A very angry man."))
      (is (string/includes? (:body response) "Likes chopping heads"))
      (is (string/includes? (:body response) "10000"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
