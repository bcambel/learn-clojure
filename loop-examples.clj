(for [x 0 y 10
      :when (> y x)
      ]
    (dec y)
  )

;; Recursive call make
(defn print-down-from [x]
  (print "working")
  (when (pos? x)
    (println x)
    (recur (dec x))))

(print-down-from 5)

(defn sum-down-from [sum x]
  (if (pos? x)
    (recur (+ sum x) (dec x))
    sum))

(sum-down-from 12 11)

(+ 12 10 9 8 7 6 5 4 3 2 1)

(defn sum-down-from2 [initial-x]
  (print "sum-down-from2")
  (loop [sum 0, x initial-x]
    (if (pos? x)
      (recur (+ sum x) (dec x))
      sum)))

(sum-down-from2 12)

(doc get)