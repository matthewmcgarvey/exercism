module Year
  extend self

  RULES = [
    p_divisible_by?(4),
    p_or(
      p_negate(p_divisible_by?(100)),
      p_divisible_by?(400)),
  ]

  def leap?(year) : Bool
    RULES.map { |rule| rule.call(year) }.all?(&.itself)
  end

  def p_divisible_by?(num : Int32) : Proc(Int32, Bool)
    ->(year : Int32) { year.divisible_by?(num) }
  end

  def p_negate(test : Proc(A, Bool)) : Proc(A, Bool) forall A
    ->(input : A) { !test.call(input) }
  end

  def p_or(a : Proc(A, Bool), b : Proc(A, Bool)) : Proc(A, Bool) forall A
    ->(input : A) { a.call(input) || b.call(input) }
  end
end
