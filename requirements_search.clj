(def requirements_file "/Users/bahadircambel/code/MetadataAdmin/requirements.txt")
(use 'clojure.java.io)
(use '[clojure.string :only (join split)])

(slurp requirements_file)

(defn process-line [line]
  (let [single-line (split line #"==")
        result (into '() single-line)]
    (reverse result)))

(process-line "Fabric==1.6")

(defn requirements-reader [file]
  (let [incoming (split (slurp file) #"\n")
        result (map #(process-line %) incoming)]
    result))

(def requirements
(requirements-reader requirements_file))

(defn search-requirements [requirements re selector]
  (filter #(re-find re %) (map #( selector %) requirements)))

(search-requirements requirements #"^1.*$" second)
(search-requirements requirements #"^.*py.*$" first)
(search-requirements requirements #"^.*Flask.*$" first)



(conj [1 2 3] 4)