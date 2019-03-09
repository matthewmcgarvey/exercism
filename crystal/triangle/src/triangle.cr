class Triangle
  def initialize(@sides : Array(Int32))
  end

  def equilateral? : Bool
    valid? && @sides.to_set.size == 1
  end

  def isosceles? : Bool
    valid? && @sides.to_set.size <= 2
  end

  def scalene? : Bool
    valid? && !isosceles?
  end

  private def valid? : Bool
    @sides.all?(&.>(0)) && @sides.permutations.all? { |(a, b, c)| a + b >= c }
  end
end
