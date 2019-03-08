
class Triangle
  @valid : Bool
  def initialize(@sides : Array(Int32))
    @valid = sides[0] > 0 \
      && sides[1] > 0 \
      && sides[2] > 0 \
      && sides[0] + sides[1] >= sides[2] \
      && sides[1] + sides[2] >= sides[0] \
      && sides[0] + sides[2] >= sides[1]
  end

  def equilateral? : Bool
    @valid && @sides.to_set.size == 1
  end

  def isosceles? : Bool
    @valid && @sides.to_set.size <= 2
  end

  def scalene? : Bool
    @valid && !isosceles?
  end
end