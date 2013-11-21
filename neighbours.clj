
; A function for finding the neighbors of a spot on a 2D matrix
; given a y-x location in an square 2D matrix, returns a sequence of the locations surrounding it
(defn neighbors
  ([size yx] (neighbors [[-1 0] [1 0] [0 -1] [0 1]] size yx))
  ; deltas local describes that a neighbor can be one spot away,
  ; but only along the x or y axis (not diagonal).
  ; The function first walks through deltas
  ([deltas size yx]
   ; and builds a vector of each added to the yx point provided.
   ; This operation will of course generate illegal point coordinates,
   ; so those are then removed using filter , which checks to ensure that
   ; the indices lie between -1 and the provided size.
     (filter (fn [new-yx]
               (every? #(< -1 % size) new-yx))
             (map #(vec (map + yx %))
                deltas))))

(neighbors 3 [0 0])
;;=> ((1 0) (0 1))

(neighbors 3 [1 1])
;=> ((0 1) (2 1) (1 0) (1 2))

(def matrix
     [
      [1 2 3]
      [4 5 6]
      [7 8 9]
     ])

; get the values of the coordinates ((1 0) (0 1))
(map #(get-in matrix %) (neighbors 3 [0 0]))
;=> (4 2)

(map #(get-in matrix %) (neighbors 3 [1 1]))
;=> (2 8 4 6)