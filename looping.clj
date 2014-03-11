;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.
;(println "helo ther")

(defn testing [x]
  (println (format "Testing")))


(defn looper [n]
  (loop [x 0]
    (if (> x n)
       nil
      (do
        (println (str "Yoo" x))
        (recur (inc x)))))
  x)

;(looper 10)

(defn counterIntel
  [coll]
  (let [x 0]
    (walk (fn [y]
           (inc x)) coll))
  x)

;(looper )
;(counterIntel '(1 2 3 3 1))
;(counterIntel "Hello World")
;(counterIntel "Hello World234234234234")
(doc walk)
