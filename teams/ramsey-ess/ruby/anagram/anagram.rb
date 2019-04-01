class Anagram
  def initialize(word)
    @word = word
  end

  def match(words)
    words.reject { |x| x.casecmp(@word).zero? }
         .select { |x| x.downcase.chars.sort == @word.downcase.chars.sort }
  end
end
