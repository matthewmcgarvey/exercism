module Bob
  def self.hey(input : String) : String
    if input.upcase == input && input.chars.any?(&.letter?)
      if input.ends_with?("?") 
        return "Calm down, I know what I'm doing!"
      end
      "Whoa, chill out!"
    elsif input.ends_with?("?")
      "Sure."
    elsif input.blank?
      "Fine. Be that way!"
    else
      "Whatever."
    end
  end
end