(ns euler.3.core
  (:use euler.util))


(defn answer
  "Needs too much heap space to run on modern hardware :(."
  []
  (last (prime-factors 600851475143)))

