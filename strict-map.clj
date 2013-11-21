(defn strict-map2 [f coll]
  (loop [coll coll, acc []]
    (if (empty? coll)
      acc
      (recur (next coll)
             (conj acc (f (first coll)))))))

(strict-map2 - (range 5))
;=> [0 -1 -2 -3 -4]