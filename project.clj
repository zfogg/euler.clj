(defproject euler "0.1.0"
  :description "Solutions for various Project Euler problems."

  :url "https://github.com/zfogg/euler.clj"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :source-paths      ["src/clojure"]
  :java-source-paths ["src/java"]

  :javac-options ["-Xlint:unchecked"]

  :main euler.core

  :dependencies [[org.clojure/clojure            "1.4.0"]
                 [org.clojure/math.numeric-tower "0.0.2"]
                 [incanter/incanter-core         "1.5.1"]
                 [incanter/incanter-charts       "1.5.1"]])

