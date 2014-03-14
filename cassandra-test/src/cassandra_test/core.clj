(ns cassandra-test.core
  (:require [clojurewerkz.cassaforte.client :as client]
            [clojure.pprint]
            )
  (:use clojurewerkz.cassaforte.multi.cql
        clojurewerkz.cassaforte.query)
  (:gen-class))

;(def cluster (client/build-cluster {:contact-points ["127.0.0.1"]
;                                    :port 19042}))

;(def session (client/connect cluster "pyhackers" ))

(def session (client/connect! ["127.0.0.1"] ))
(use-keyspace session "pyhackers")

(defn doqueries []
  (println (select session "user"))
  (println "=========================")
  (clojure.pprint/pprint (select session "discussion")))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (doqueries))
