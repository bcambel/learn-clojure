(defn summer
  [coll]
  (reduce + coll)
  )

(summer [1 2 3])
(summer (list 0 -2 5 5))
(summer #{4 2 1})

(take 2 [1 2 3])
(take-last 2 [1 2 3])

(defn splitter [split x]
  (let [len (count x) ]
    (concat
     (vec (list (take split x)))
    (vec (list ( nthrest  x split)))
    ))
  )

(splitter 1 [1 2 3 4])
(splitter 2 [1 2 3 4])