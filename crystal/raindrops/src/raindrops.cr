module Raindrops

  def self.drops(num : Int32) : String
    String.build do |str|
      str << "Pling" if num.divisible_by?(3)
      str << "Plang" if num.divisible_by?(5)
      str << "Plong" if num.divisible_by?(7)
      str << num.to_s if str.empty?
    end
  end
end