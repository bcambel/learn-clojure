(ns play-cascalog.core
	(:use cascalog.api)
	(:require [cascalog.logic.ops :as c])
  (:gen-class))

(defn print-file
  "Use cascalog to print a file"
  [file-path]
  (let [file-tap (lfs-textline file-path)]
    (?<- (stdout) [?line] (file-tap :> ?line))))

(defn print-out
  [lines]
  (map println lines)
  )

(defn print-parsed-file
  [file-path]
  (let [source (lfs-textline file-path)
        print-out (?<- [?line] (source :> ?line))
        ]
      print-out)
  )

(defn follows-data [dir]
  (let [source (hfs-textline dir)]
    (<- [?p ?p2] (source ?line) (c/re-parse [#"[^\s]+"] ?line :> ?p ?p2)
                     (:distinct false))))

(defn to-long [num] (Long/parseLong num))

(defn action-data [dir]
  (let [source (hfs-textline dir)]
    (<- [?p ?a ?t] (source ?line) (c/re-parse [#"[^\s]+"] ?line :> ?p ?a ?time-str)
                   (to-long ?time-str :> ?t) (:distinct false))))

(def action-mapping { :print print-file :follow follows-data :action action-data })

(defn -main
  "Entry point"
  [action file-path]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "Printing file" file-path)
  (apply (get action-mapping action) file-path )
  ; (print-file file-path)
  )
