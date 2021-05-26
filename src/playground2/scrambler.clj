(ns playground2.scrambler)

(require '[clojure.spec.alpha :as s])

;; Internals
(defn- str-to-keyword-map [s]
    "transforms string s into a map of keyword chars"
    (map keyword (map str s)))
    
(defn- to-counted-map [s]
    "make map of symbol chars with counted occuerrences in string s"
    (reduce #(assoc %1 %2 (inc (%1 %2 0))) {} (str-to-keyword-map s)))

(defn- get-counted-symb [symb m]
    "get number of occurences of symbol symb in map m"
    (if (nil? (get m symb)) 
        0
        (get m symb)))

(defn- check-enough-symb [symb m1 m2]
    "check if the target symbol in m1 is greater of equal to the count in m2"
    (>= (get-counted-symb symb m1) (get-counted-symb symb m2)))

(defn- checker-all [m1 m2]
    "checks if every key in map m2 has enough representation in map m1"
    (every? #(check-enough-symb % m1 m2) (keys m2)))    
    
;; Public
(defn scramble? [s1 s2]
    "returns if is possible to build s2 out of the chars present in s1"
    (let [m1 (to-counted-map s1) m2 (to-counted-map s2)]  
        (checker-all m1 m2)))

;; Specs
(s/def ::valid-string  (s/and string? not-empty))
(s/def ::target-string (s/and ::valid-string #(= "abc")))
(s/def ::source-string (s/and ::valid-string contains? "abc"))


(s/fdef scramble?
    :args (s/and (s/cat :s1 string? :s2 string?))
    :ret boolean?)

