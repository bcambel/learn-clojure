((fn
  [mylist index]
   (first
    (reverse
     (take index mylist)))) '(4 5 6 12 1) 4)


(let [x y]
  (inc x)
  (print x)
  x)

((fn [[x y]]
  (if (> x y)
    x
    y
    )
  ) [10 8])

(defn comparor
  [[x y]] (if (> x y) x y))
(comparor [1 2])
  (partition 2 [ 1 8 3])

(vec (map comparor (map vec (partition 2 [ 1 8 3]))))
((fn compareVals [[x y]] (if (> x y) x y)) [8 90])


((fn [x] (take x (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1])))) 10)

(def l [1 2 3 2 1])

(count l)

(defn counter [len callingFunc]
  (loop [x 0]
    (if (< x len)
      (do
        (print (str " : " x))
        (callingFunc x)
        (recur (inc x))
      )
      (print "done")
      )
    ))

;(counter 10 #(print %))
(defn pal2
  [coll]
  (let [x (count coll)]
    (do
      (println (take  (/ (count coll) 2)  coll))
      (println (drop  (/ (count coll) 2)  coll))
      (=
        (list (take  (/ (count coll) 2) (list coll)))
       (list (nthrest coll (/ (count coll) 2)))
       )
      )
    )
  )
;(take [ 1 2 ] 2)

(pal2 l)
(pal2 "bahadir")
(pal2 [:foo :bar :foo])

(defn pallindrome
  [coll]
  (map
   (fn [x]
     (= (nth coll x)
        (nth coll
             (dec
              (- (count coll) x)
              ))))
   coll ))
(pallindrome "racecar")
(pallindrome l)
(pallindrome [1 2 3 2 1])




