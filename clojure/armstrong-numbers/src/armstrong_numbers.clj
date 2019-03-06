(ns armstrong-numbers)

(defn armify [num count]
  (-> num
    (Character/digit 10)
    (Math/pow count)
    bigint)
)

(defn armstrong? [num]
  (let [str_num (str num)
        length (count str_num)]
    (<= num (reduce + (map #(armify % length) str_num))))
)
