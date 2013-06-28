(ns euler.util
  (:use clojure.math.numeric-tower)
  (:import [euler.primes PrimeSieve]))

(declare factor?)


(def !& partial)

(def !$ comp)


(defn any?
  "Checks if a sequence of booleans contains 'true'."
  [xs]
  (reduce #(or (true? %1) (true? %2)) xs))

(defn all?
  "Checks if a sequence of booleans are all 'true'."
  [xs]
  (reduce #(and (true? %1) (true? %2)) xs))


(def sum
  (!& reduce +))

(def sum'
  (!& reduce +'))

(def product
  (!& reduce *))

(def product'
  (!& reduce *'))


(defn fast-prime?
  "Primality test for odd integers greater than 4."
  [n]
  (all? (map
          (!$ not (!& factor? n))
          (range 3 (inc (sqrt n)) 2))))

(defn prime?
  [n]
  (if (or (even? n) (>= 1 n))
    (= 2 n)
    (if (any? (map (!& = n) [2 3 5]))
      true
      (fast-prime? n))))


(def primes
  (letfn [(candidates []
            (lazy-cat [7 11] (map #(+ 6 %) (candidates))))]
    (concat [2 3 5] (filter fast-prime? (candidates)))))

(def fibs
  (lazy-cat [0 1] (map + fibs (rest fibs))))


(defn factor?
  "Checks if 'n' has a factor 'f'."
  [n f]
  (zero? (mod n f)))

(defn prime-factors
  [n]
  (let [candidates (PrimeSieve. (quot n 2))]
    (filter (!& factor? n) (seq candidates))))


(defn int-to-digits
  [n]
  (if (= n 0)
    []
    ((!$ (!& map int) concat)
     ((!$ int-to-digits floor) (/ n 10))
     [(mod n 10)])))

(defn digits-to-int
  [coll]
  (let [x (first coll) xs (rest coll)]
    (if (empty? xs)
      x
      (+ (* x (expt 10 (count xs)))
         (digits-to-int xs)))))

(defn f-on-digits
  [f]
  (!& (!$ digits-to-int f int-to-digits)))

(defn palindrome?
  [n]
  (let [xs   (int-to-digits n)
        half (floor (/ (count xs) 2))
        fst  (take      half xs)
        snd  (take-last half xs)]
    (= fst (reverse snd))))


(defn rotate-right
  [xs]
  (conj (butlast xs) (last xs)))

(defn rotate-left
  [xs]
  (conj (vec (rest xs)) (first xs)))

(defn lazy-mapcat
  [f coll]
  (lazy-seq
    (if (not-empty coll)
      (concat
        (f (first coll))
        (lazy-mapcat f (rest coll))))))

(def search
  (!$ first filter))

