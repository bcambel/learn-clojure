(ns kafka-test.core
  (use clj-kafka.zk)
  (use clj-kafka.consumer.zk)
  (use clj-kafka.core)
  (:gen-class))

;(def config {:zookeeper-port 2182
;             :kafka-port 9999
;             :topic "clj"})

;(def zk-connect {"zookeeper.connect" "127.0.0.1:2182"})

;(def config {"zookeeper.connect" "localhost:2181"
;             "group.id" ""
;             "auto.offset.reset" "smallest"
;             "auto.commit.enable" "false"})

(def producer-config {"metadata.broker.list" "localhost:9092"
                      "serializer.class" "kafka.serializer.DefaultEncoder"
                      "partitioner.class" "kafka.producer.DefaultPartitioner"
                      })

(def consumer-config {
                       "zookeeper.connect" "127.0.0.1:2181"
                       "serializer.class" "kafka.serializer.DefaultEncoder"
                       "group.id" "test-consumer-group" })

(defn -main
  [& args]
  (alter-var-root #'*read-eval* (constantly false))
  (println "Hello, World!")
  (with-resource [c (consumer consumer-config)]
                 shutdown
                 (take 5 (messages c "clj")))
  )
