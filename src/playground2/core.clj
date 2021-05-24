(ns playground2.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn sampler [name other] 
  (if (= other true) 
    (str name " and no other")
    (str "no other than " name))
  )


