(ns euler.1.core
  (:use euler.util
        clojure.set))


(defn multiples
  "Returns multiples of all 'args' that are in 'xs'."
  [xs & args]
  (let [xs$ (filter #(factor? % (first args)) xs)]
    (if (empty? (rest args))
      xs$
      (union xs$ (apply multiples xs (rest args))))))

(defn answer
  []
  (sum (into #{} (multiples (range 1000) 3 5))))

