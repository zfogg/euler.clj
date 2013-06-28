(ns euler.9.core
  (:use [euler.util]
        [incanter.core   :only [$=]])
  (:import [euler.problem9 Core]))


;BEGIN OLD WORK
(defn t1
  [[a b c]]
  [($=  1 * a - 2 * b + 2 * c)
   ($=  2 * a - 1 * b + 2 * c)
   ($=  2 * a - 2 * b + 3 * c)])

(defn t2
  [[a b c]]
  [($=  1 * a + 2 * b + 2 * c)
   ($=  2 * a + 1 * b + 2 * c)
   ($=  2 * a + 2 * b + 3 * c)])

(defn t3
  [[a b c]]
  [($= -1 * a + 2 * b + 2 * c)
   ($= -2 * a + 1 * b + 2 * c)
   ($= -2 * a + 2 * b + 3 * c)])

(defn ts
  [abc]
  [(t1 abc) (t2 abc) (t3 abc)])

(def pythTrips
  (lazy-cat [[3 4 5]] (lazy-mapcat ts pythTrips)))

(defn groupBy
  [n xs]
  (if (empty? xs)
    []
    (cons (vec (take n xs)) (groupBy n (drop n xs)))))
; END OLD WORK

(defn pyth-trip?
  [[a b c]]
  (= (* c c) ($= a * a + b * b)))

(defn answer
  "Not working yet."
  []
  (search (!$ (!& = 1000) sum) pythTrips))

