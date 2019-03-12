(ns reverse-string)
(use '[clojure.string :only (join)])

(defn reverse-chars [chars]
  (reduce #(cons %2 %1) [] chars))

(defn reverse-string [s]
    (join (reverse-chars (char-array s))))
