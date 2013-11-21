;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.
(defn sum-even-numbers [nums]
  (if-let [nums (seq (filter even? nums))]
    (reduce + nums)
    "No even numbers found."))

(sum-even-numbers [1 2 3 5 7 9 11 22 33 44])