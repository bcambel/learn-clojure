(ns riemann-cli.core
  (use 'riemann.client)
  (:gen-class))


(def c (tcp-client :host "s6.io" :port 5555 ))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "Hello, World!"))
