module Hamming

  def self.compute(a,b)
    raise ArgumentError.new if a.size != b.size
    a.chars
      .zip(b.chars)
      .map { |a,b| a == b ? 0 : 1 }
      .sum
  end
end