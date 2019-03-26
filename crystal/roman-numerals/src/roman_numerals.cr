
struct Int
  CONVERSIONS = {
    1 => "I",
    4 => "IV",
    5 => "V",
    9 => "IX",
    10 => "X",
    40 => "XL",
    50 => "L",
    90 => "XC",
    100 => "C",
    400 => "CD",
    500 => "D",
    900 => "CM",
    1000 => "M"
  }

  def to_roman : String
    String.build do |str|
      temp = self
      while temp > 0
        num = CONVERSIONS.keys
          .select(&.<=(temp))
          .max
        str << CONVERSIONS[num]
        temp -= num
      end
    end
  end
end