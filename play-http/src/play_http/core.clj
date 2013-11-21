(ns play-http.core
	(:require [clj-http.client :as client])
  (:gen-class))

(defn download 
	[website]
	(client/get website))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "Hello, World!")
  (download "http://pythonhackers.com")
  )
