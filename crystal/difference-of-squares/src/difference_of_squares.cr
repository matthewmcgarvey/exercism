# Please implement your solution to difference-of-squares in this file
module Squares
  extend self

  def square_of_sum(n : Int32) : Int32
    (1..n).sum.squared
  end

  def sum_of_squares(n : Int32) : Int32
    (1..n).map(&.squared).sum
  end

  def difference_of_squares(n : Int32) : Int32
    square_of_sum(n) - sum_of_squares(n)
  end
end

struct Int32
  def squared
    self * self
  end
end