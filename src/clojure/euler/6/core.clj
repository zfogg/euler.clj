(ns euler.6.core
  (:use euler.util
        clojure.math.numeric-tower))


(def naturals (range 100))

(def sum-squares
  (sum (map #(expt % 2) naturals)))

(def square-sum
  (expt (sum naturals) 2))


(defn answer
  []
  (abs (- sum-squares square-sum)))


