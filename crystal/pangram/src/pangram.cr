module Pangram
  extend self
  ALPHABET = ('a'..'z').to_set
  def pangram?(input : String) : Bool
    input.downcase
      .chars
      .select(&.ascii_letter?)
      .to_set == ALPHABET
  end
end