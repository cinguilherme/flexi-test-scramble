(ns playground2.scrambler)

(defn- str-to-mapl [s]
    (map keyword (map str s)))
    
(defn- to-counted-map [s]
    (reduce #(assoc %1 %2 (inc (%1 %2 0))) {} (str-to-mapl s)))

(defn- get-counter [symb m]
    (if (nil? (get m symb)) 
        0
        (get m symb)))

(defn- check-enough-symb [symb m1 m2]
    (>= (get-counter symb m1) (get-counter symb m2)))

(defn- checker-all [m1 m2]
    (every? #(check-enough-symb % m1 m2) (keys m2)))    
    
(defn scramble? [s1 s2]
    (let [m1 (to-counted-map s1) m2 (to-counted-map s2)]  
        (checker-all m1 m2)))

