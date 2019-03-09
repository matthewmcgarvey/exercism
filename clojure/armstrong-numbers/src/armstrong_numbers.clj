(ns armstrong-numbers)

(defn raise [num count] (reduce * (repeat count num)))

(defn split [num]
  (map #(Character/digit % 10) (str num)))
 
(defn raise_all [nums pow]
  (map #(raise % pow) nums))

(defn sum [nums]
  (reduce + nums))

(defn convert [num]
  (let [nums (split num)
        length (count nums)
        raised (raise_all nums length)]
    (sum raised)))

(defn armstrong? [num]
    (= num (convert num)))
