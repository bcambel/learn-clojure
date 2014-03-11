(defproject play_cascalog "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
	[cascalog "2.0.0"]
  ]
  :profiles { :dev {:dependencies [[org.apache.hadoop/hadoop-core "1.1.2"]]}}
  :jvm-opts ["-Xmx768m"]
  :main play_cascalog.core)
