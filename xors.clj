(defn xors [max-x max-y]
  (for [x (range max-x) y (range max-y)]
       [x y (bit-xor x y)]))

;([0 0 0] [0 1 1] [1 0 1] [1 1 0])
(xors 2 2)