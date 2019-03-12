class Series
  def initialize(@digits : String)
  end

  def largest_product(length : Int32)
    raise ArgumentError.new(
      "length cannot be more than the size of digits") if length > @digits.size
    return 1 if length.zero?
    @digits
      .chars
      .map(&.to_i64)
      .each_cons(length)
      .map(&.product)
      .max
  end
end
