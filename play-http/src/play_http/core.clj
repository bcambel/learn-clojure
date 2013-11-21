(ns play-http.core
	(:require [clj-http.client :as client])
	(:use cascalog.api)
  (:gen-class))

(defn download 
	[website]
	(client/get website))

(defn print-file
  "Use cascalog to print a file"
  [file-path]
  (let [file-tap (lfs-textline file-path)]
    (?<- (stdout) [?line] (file-tap :> ?line))))

(defn -main
  "Entry point"
  [file-path]
  (println "Printing file" file-path)
  (print-file file-path)
  )

; (defn -main
;   "I don't do a whole lot ... yet."
;   [& args]
;   ;; work around dangerous default behaviour in Clojure
;   (alter-var-root #'*read-eval* (constantly false))
;   (println "Hello, World!")
;   (download "http://pythonhackers.com")
;   )
