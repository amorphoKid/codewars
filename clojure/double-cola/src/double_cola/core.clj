(ns double-cola.core
  (:gen-class))

(def names ["Sheldon" "Leonard" "Penny" "Rajesh" "Howard"])

(def first-group (map vector (repeat 1) names)
)

(defn double-group [[size name]]
   [(* 2 size) name]
  )

(defn sum-of-drinks []
  (reductions + (map first (groups)))
  )

(defn get-person-of-nth-drink [nth-drink]
  (last (nth (groups) (count (take-while #(< % nth-drink) (sum-of-drinks)))))
  )

(defn groups []
  (lazy-seq (concat first-group
                    (map double-group (groups))))
  )
            

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (take-while #(< % 100) (reductions + (map first (groups))))
  (last (last (take (count (take-while #(< % 100) (reductions + (map first (groups))))) (groups))))
  )
