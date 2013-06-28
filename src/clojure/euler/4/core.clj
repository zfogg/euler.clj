(ns euler.4.core
  (:use euler.util))


(def candidates
  (for [i (range 999 99 -1)
        j (range 999 99 -1)
        :let [n (* i j)]
        :when (palindrome? n)]
    n))

(defn answer
  []
  (apply max candidates))

