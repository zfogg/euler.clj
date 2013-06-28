(ns euler.7.core
  (:use euler.util
        clojure.math.numeric-tower)
  (:import (euler.primes PrimeSieve)))


(defn answer
  []
  (let [n      10001
        limit  (long (expt n 1.618))
        primes (PrimeSieve. limit)]
    (nth (seq primes) n)))


