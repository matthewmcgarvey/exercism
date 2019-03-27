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
    1000 => "M",
  }

  def to_roman : String
    return "" if self <= 0

    num, roman = CONVERSIONS
      .select { |k, v| k <= self }
      .max_by { |k, v| k }
    roman + (self - num).to_roman
  end
end
