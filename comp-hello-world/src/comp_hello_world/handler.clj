(ns comp-hello-world.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/user/:id" [id]
       (str "<h1>Hello user " id "</h1>"))
  (GET "/map/:x" [x]
       (time (str  (reduce + (map #(* 2 %) (range (read-string x)))))))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
