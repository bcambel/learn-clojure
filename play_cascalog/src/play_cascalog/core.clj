(ns play_cascalog.core
	(:use cascalog.api)
	(:require [cascalog.logic.ops :as c]
            [clojure.string :as s]
            [clojure.tools.logging :as logging :refer [error info warn]])
  (:gen-class))


(defn file
   [path]
    (let [ file-path (if (s/blank? path) "test-logs/test.log" path)
           file-tap (lfs-textline file-path)]
      (logging/warn (format "Loading file %s" path)
      (<- [?line] (file-tap :> ?line))))

(defn parse-log-file
  [path]

  )

(defn parse [line] (clojure.string/split line #" " 3))

(defn split-into-words [source]
  (<- [?name ?kw ?timestamp]
    (source :> ?line)
    (parse ?line :> ?name ?kw ?timestamp)))

(defn doubleit [val] (* 2 (Long/parseLong val)))

(defn count-uniq-names
  [source]
  (<- [?name ?count]
    (source ?name ?kw ?timestamp)
    (cascalog.logic.ops/count ?count)))

(defn doubler
  [source]
  (<- [?name ?timestamp ?doubled]
    (source :< ?name ?kw ?timestamp)
    (doubleit ?timestamp :> ?doubled)))

(defn say-hello
  [name]
  (format "hello my friend %s" name))

(defn be-expressive
  [source]
  (<- [?name ?timestamp ?doubled ?feeling]
    (source ?name ?timestamp ?doubled)
    (say-hello ?name :> ?feeling)
    )
  )

(defn expressive-friend
  []
  (?- (stdout) (be-expressive (doubler (split-into-words (file)))))
  )

(defn expres
  []
  (->> (file)
    (split-into-words)
    (doubler)
    (be-expressive)
    )
  )

;(defn printer
;  [file]
;    (let [splitted-words (split-into-words (file))
;          unique-names (count-uniq-names splitted-words)
;           doubled (doubler splitted-words)
;          ]
;      (?- (stdout) unique-names)
;      ))

(defn -main
  "Entry point"
  [action file-path]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "Printing file" file-path)
  )
