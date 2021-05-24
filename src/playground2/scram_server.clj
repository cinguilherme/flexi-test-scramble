(ns playground2.scram_server
    (:require [ring.adapter.jetty])
    (:require [ring.util.request :refer :all])
    (:require [ring.middleware.params :refer :all])
    (:require [playground2.scrambler :refer [ scramble? ]])
    (:import [java.io StringReader])
    )

(require '[ring.middleware.json :refer [wrap-json-response]]
        '[ring.util.response :refer [response]])

(defn scramble-handler [request]
    (prn (get (params-request request) :params))
    (let [params (get (params-request request) :params)]
        (let [str1 (get params "str1")  str2 (get params "str2")]
            {
                :status 200
                :headers { "ContentType" "application/json" }
                :body (str "{str1:" str1 ", str2:" str2 ", isScramblable:" (scramble? str1 str2) "}")
            })))

(use 'ring.adapter.jetty)

(run-jetty scramble-handler {:port 8080 :join? false})