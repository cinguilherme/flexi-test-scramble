(defproject playground2 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"] 
                [prismatic/schema "1.1.12"]
                [medley "1.3.0"]
                [ring "1.9.3"]
                [ring/ring-json "0.5.1"]
                [ring/ring-jetty-adapter "1.8.2"]
                ]
  
  :main ^:skip-aot playground2.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})