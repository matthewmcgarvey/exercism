module Raindrops
  FACTORS_TO_RAINDROPS = {
    3 => "Pling",
    5 => "Plang",
    7 => "Plong",
  }

  def self.drops(num : Int32) : String
    FACTORS_TO_RAINDROPS
      .select { |factor, _| num.divisible_by?(factor) }
      .values
      .join
      .default_if_blank?(num.to_s)
  end
end

class String
  def default_if_blank?(default : String) : String
    self.blank? ? default : self
  end
end
