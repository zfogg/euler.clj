(ns euler.core-test
  (:use [clojure.test
         euler.core
         euler.util]))


(deftest primes-test
  (testing "The first twenty values of the 'primes' var."
    (is (=
         (take 20 primes)
         [2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71]))))

(deftest fast-prime?-test
  (testing "Boolean primality test for odd integers greater than 4."
    (is (=
         (map fast-prime? [5 7 9 11 13 15])
         [true true false true true false]))))

(deftest prime?-test
  (testing "Boolean primality test for all integers."
    (is (=
         (map prime? [-15 -5 0 1 2 3 4 15 17 20])
         [false false false false true true false false true false]))))

(deftest prime-test
  (testing "Finds all prime factors of a number."
    (is (=
         (map prime-factors [11 12 20 70])
         [[] [2 3] [2 5] [2 5 7]]))))


(let [x  1350918713009
      xs [1 3 5 0 9 1 8 7 1 3 0 0 9]]
  (deftest int-to-digits-test
    (testing "Change an integer to its digits."
      (is (=
           xs
           (int-to-digits x)))))
  (deftest digits-to-int-test
    (testing "Change a list of digits to an integer."
      (is (=
           x
           (digits-to-int xs))))))


(deftest palindrome?-test
  (testing "Boolean primality test for integers."
    (is (=
         [true false]
         [(palindrome? 123454321)
          (palindrome? 123456321)]))))

