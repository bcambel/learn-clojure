(def guys-name-map {:f-name "Guy" :l-name "Steele" :m-name "Lewis"})

; :keys | a vector of names convert to keys
(let [{:keys [f-name m-name l-name]} guys-name-map]
  (str l-name ", " f-name " " m-name))
;=> "Steele, Guy Lewis"


; destructure using :keys ; map to keys
; & args converted into keys
(defn whole-name [& args]
  (let [{:keys [f-name m-name l-name]} args]
    (str l-name ", " f-name " " m-name)))

(whole-name :f-name "Guy" :m-name "Lewis" :l-name "Steele")
;=> "Steele, Guy Lewis"


;only select a specific part of it using :keys.
(defn print-last-name [{:keys [l-name]}]
  (println l-name))
(print-last-name guys-name-map)
; Steele


; extract both a named parameter, and
; also preserve the whole with :as keyword
(let [{f-name :f-name, :as whole-name} guys-name-map]
  (println "First name is" f-name)
  (println "Whole name is below:")
  whole-name)
;First name is Guy
;Whole name is below:
; => {:f-name "Guy", :l-name "Steele", :m-name "Lewis"}

; a key not found; using ":or" to set default (rather than nil)
(let [{:keys [title f-name m-name l-name],
       :or {title "Mr."}} guys-name-map]
  (println title f-name m-name l-name))
; Mr. Guy Lewis Steele
;=> nil