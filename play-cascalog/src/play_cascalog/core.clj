(ns play-cascalog.core
	(:use cascalog.api)
  (:gen-class))

(defn print-file
  "Use cascalog to print a file"
  [file-path]
  (let [file-tap (lfs-textline file-path)]
    (?<- (stdout) [?line] (file-tap :> ?line))))

(defn -main
  "Entry point"
  [file-path]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "Printing file" file-path)
  (print-file file-path)
  )
