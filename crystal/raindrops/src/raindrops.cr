module Raindrops
  FACTORS_TO_RAINDROPS = {
    3 => "Pling",
    5 => "Plang",
    7 => "Plong",
  }

  def self.drops(num : Int32) : String
    FACTORS_TO_RAINDROPS
      .select { |factor, _| num.divisible_by?(factor) }
      .map { |_, sound| sound }
      .join
      .tap { |sound| return num.to_s if sound.empty? }
  end
end
