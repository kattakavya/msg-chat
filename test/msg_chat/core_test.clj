(ns msg-chat.core-test
  (:require [clojure.test :refer :all]
            [msg-chat.core :refer :all]))

(deftest add
  (is (= 2 (+ 1 1))))



(deftest prnt
  (is (= 5 (+ 2 1))))

(deftest string
  (is (= "Hello" "Hellow")))

(defn str1 [msg]
  (str "Hello " msg))

(deftest stin1
 (testing "st"
    (is (= "Hello World" (str1 "world")))))

(deftest number
  (is (= 2 (count [1 2 3]))))

(deftest increament
  (is (= 3 (inc 3))))

(deftest num-inc
  (number)
  (increament))

(defn add [x y] (+ x y))

(deftest using-are
  (are [x y] (= 4 (add x y))
    2 3
    1 4
    3 2))

