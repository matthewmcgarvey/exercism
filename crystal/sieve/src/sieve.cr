module Primes
  def self.sieve(limit : Int) : Array(Int32)
    (2..limit)
      .select { |i| is_prime?(i) }
  end

  private def self.is_prime?(num)
    (1..num)
      .count { |x| num % x == 0 } == 2
  end
end