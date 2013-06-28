(ns euler.2.core
  (:use euler.util))


(def answer
  (sum
    (filter even?
      (take-while (partial > 4000000000000000000) fibs))))

