(ns webproject.data-test
  (:require [clojure.test :refer [deftest is testing]]
            [webproject.data.data :refer [get-profile]]))

(deftest test-data
  (testing "test get-profile"
    (let [profile (get-profile :1)]
      (is (= (:name profile) "Kharn the Betrayer"))
      (is (= (:age profile) 10000))
      (is (= (:image profile) "/images/kharn.webp"))
      (is (= (:description profile) "A very angry man."))
      (is (= (:hobbies profile) "Likes chopping heads"))
      (is (= (:id profile) 1)))))

