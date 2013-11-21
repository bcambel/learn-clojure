(first [1 2 3])
(rest [1 2 3])
(nth [1 2 3] 2)
(conj [1] [1 2 3])
(cons '(1) [1 2 3])
(cons [1] [1 2 3])

(reverse [1 2 3])
(rseq [1 2 3])
(take 2 [1 2 3 4])
(take-last 2 [1 2 3 4])
(partition 2 [1 2 3 4])


;; HASH MAPS
(hash-map :a 1 :b 2 :c 3)
(seq (keys (hash-map :a 1 :b 2 :c 3)))
(seq (vals (hash-map :a 1 :b 2 :c 3)))

(let [my-vector [:a :b :c]]
  (into my-vector (range 10)))
;=> [:a :b :c 0 1 2 3 4 5 6 7 8 9]


(map vector [1] [2])
;([1 2])

(map vector [1 2])
;([1] [2])

; Primitive Vectors
; Clojure can store primitive types inside of vectors
; using the vector-of function, which takes any of :int, :long,
; :float, :double, :byte, :short, :boolean, or :char as its argument and
; returns an empty vector. This returned vector will act just like
;any other vector, except that it’ll store its contents as primitives internally.
(into (vector-of :int) [Math/PI 2 1.3])
;=> [3 2 1]
(into (vector-of :char) [100 101 102])
;=> [\d \e \f]

(def a-to-j (vec (map char (range 65 75))))
a-to-j
;=> [\A \B \C \D \E \F \G \H \I \J]

(nth a-to-j 4)
;=> \E
(get a-to-j 4)
;=> \E
(a-to-j 4)
;=> \E

(seq a-to-j)
;=> (\A \B \C \D \E \F \G \H \I \J)

(rseq a-to-j)
;=> (\J \I \H \G \F \E \D \C \B \A)

(assoc a-to-j 4 "no longer E")
;=> [\A \B \C \D "no longer E" \F \G \H \I \J]

(replace {2 :a, 4 :b} [1 2 3 2 3 4])
;=> [1 :a 3 :a 3 :b]

(subvec a-to-j 3 6)
;=> [\D \E \F]

(def matrix
     [[1 2 3]
      [4 5 6]
      [7 8 9]])

(get-in matrix [1 2])
;=> 6

(assoc-in matrix [1 2] 'x)
;=> [[1 2 3] [4 5 x] [7 8 9]]

;takes a function to apply to an existing value.
(update-in matrix [1 2] * 100)
;=> [[1 2 3] [4 5 600] [7 8 9]]

(def my-stack [1 2 3])
(peek my-stack)
;=> 3
(pop my-stack)
;=> [1 2]
(conj my-stack 4)
;=> [1 2 3 4]
(+ (peek my-stack) (peek (pop my-stack)))
;=> 5

(defn strict-map2 [f coll]
  (loop [coll coll, acc []]
    (if (empty? coll)
      acc
      (recur (next coll)
             (conj acc (f (first coll)))))))
(strict-map2 - (range 5))
;=> [0 -1 -2 -3 -4]

(into [1 2 3 4] 3)