module Bob
  def self.hey(input : String) : String
    if shouting?(input)
      if question?(input)
        "Calm down, I know what I'm doing!"
      else
        "Whoa, chill out!"
      end
    elsif question?(input)
      "Sure."
    elsif silent?(input)
      "Fine. Be that way!"
    else
      "Whatever."
    end
  end

  private def self.shouting?(input)
    input.upcase == input && input.chars.any?(&.letter?)
  end

  private def self.question?(input)
    input.ends_with?("?")
  end

  private def self.silent?(input)
    input.blank?
  end
end