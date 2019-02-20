module Brackets
  def self.are_valid?(input)
    brackets = {
      '['=> ']',
      '{'=> '}',
      '('=> ')'
    }
    stack = [] of Char
    input.each_char do |c|
      if brackets.has_key?(c)
        stack << c
      elsif brackets.has_value?(c) && stack.any?
        if brackets.key_for?(c) != stack.pop
          break
        end
      end
    end
    return stack.empty?
  end
end