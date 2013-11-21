

(def fnx
  (fn [coll times]
    (reduce concat (merge (vec (map #(merge ( repeat times %)) coll )))))
)

(fnx [1 2 3] 2)
;(1 1 2 2 3 3)
(fnx [[1 2] [3 4]] 2)
;([1 2] [1 2] [3 4] [3 4])


(defn count-seq
  [coll]
    (reduce + (map (fn [x] (/ 1 1)) coll))
  )

