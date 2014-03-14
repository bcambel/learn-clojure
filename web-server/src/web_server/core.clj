(ns web-server.core
  (:use ring.adapter.jetty)
  (:use compojure.core)
  (:require [ring.util.response :refer [response]]
            [compojure.route :as route]
            )
   (:gen-class))

(defroutes app
           (GET "/" [] "<h1>Hello World</h1>")
           (GET "/user/:id" [id]
                (str "<h1>Hello user " id "</h1>"))
           (route/not-found "<h1>Page not found</h1>"))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello World"})


(defn handler [request]
  (response (str ) "Thank god it works"))

(defn what-is-my-ip [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (:remote-addr request)})

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure

  (run-jetty handler {:port 3000}))
