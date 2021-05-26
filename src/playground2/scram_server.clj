(ns playground2.scram_server
    (:require [ring.util.request :refer :all])
    (:require [ring.middleware.params :refer :all])
    (:require [playground2.scrambler :refer [ scramble? ]])
    (:import [java.io StringReader])
    )

(use 'ring.adapter.jetty)
(require '[jumblerg.middleware.cors :refer [wrap-cors]])

(require '[ring.middleware.json :refer [wrap-json-response]]
        '[ring.util.response :refer [response]])

(defn scramble-handler [request]
    (prn (get (params-request request) :params))
    (let [params (get (params-request request) :params)]
        (let [str1 (get params "str1")  str2 (get params "str2")]
            {
                :status 200
                :headers { "Content-Type" "application/json" }
                :body { :isScramblable? (scramble? str1 str2) }
            })))

(run-jetty (wrap-json-response (wrap-cors scramble-handler #".*"))
    {:port 8080 :join? false})