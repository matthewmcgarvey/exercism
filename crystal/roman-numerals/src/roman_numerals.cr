struct Int
  CONVERSIONS = {
    1000 => "M",
    900 => "CM",
    500 => "D",
    400 => "CD",
    100 => "C",
    90 => "XC",
    50 => "L",
    40 => "XL",
    10 => "X",
    9 => "IX",
    5 => "V",
    4 => "IV",
    1 => "I",
  }

  def to_roman : String
    return "" if self <= 0

    num, roman = CONVERSIONS.find({0, ""}) {|k,v| k <= self}
    roman + (self - num).to_roman
  end
end
