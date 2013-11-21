;; Note that this operator (along with ->>) has at times been
;; referred to as a 'thrush' operator.


;; Perhaps easier to read:
(-> "a b c d"
           .toUpperCase
           (.replace "A" "X")
           (.split " ")
           first)
;"X"

(def person
            {:name "Mark Volkmann"
             :address {:street "644 Glen Summit"
                       :city "St. Charles"
                       :state "Missouri"
                       :zip 63304}
             :employer {:name "Object Computing, Inc."
                        :address {:street "12140 Woodcrest Dr."
                                  :city "Creve Coeur"
                                  :state "Missouri"
                                  :zip 63141}}})

(-> person :employer :address :city)
;"Creve Coeur"

;; An example of using the "thread-last" macro to get
;; the sum of the first 10 even squares.
(->> (range)
     (map #(* % %))
     (filter even?)
     (take 10)
     (reduce +))
;1140

;; This expands to:
(reduce +
        (take 10
              (filter even?
                      (map #(* % %)
                           (range)))))
;1140



