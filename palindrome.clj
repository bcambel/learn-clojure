;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.
(defn pal2
  [coll]
  (let [split (quot (count coll) 2)
        ]
    (do
      (println (format "Decidin:%s%s" x coll))
      (println (take  split  coll))
      (println (reverse (take-last split coll)))
      (=
       (take  split coll)
       (reverse (take-last split coll))
       )
      )
    )
  )




(fn [coll]
    (let [split (quot (count coll) 2)]
    (do
      (=
       (take  split coll)
       (reverse (take-last split coll))
       ))))
;(quot 10 2)

(= "rac" "rac")
(take 3 "racecar")
(drop 3 "racecar")
(drop 3 [1 2 3 4 5])
;(pal2 [1 2 3])

(pal2 [1 2 2 1])
(pal2 [1 2 2 1 1])
(pal2 [1 2 3 3 2 1])
(pal2 [1 2 3 4 4 3 2 1])
(pal2 "bahadir")
(pal2 "racecar")
(pal2 '(:a :b :c))
(pal2 '(1 1 3 3 1 1))