(ns euler.5.core
  (:use euler.util))


(def candidates (range 20 Double/POSITIVE_INFINITY 20))

(defn valid
  [n]
  (all? (map (partial factor? n) (range 2 21))))


(defn answer
  []
  (search valid candidates))

