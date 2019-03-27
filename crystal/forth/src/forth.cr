module Forth
  OPERATIONS = {
    "+" => ->sum(Array(Int32)),
    "-" => ->diff(Array(Int32)),
    "*" => ->product(Array(Int32)),
    "/" => ->division(Array(Int32)),
    "dup" => ->dup(Array(Int32)),
    "drop" => ->drop(Array(Int32)),
    "swap" => ->swap(Array(Int32)),
    "over" => ->over(Array(Int32)),
  }

  def self.evaluate(input) : Array(Int32)
    actual = inline_definitions(input.downcase)
    actual.split(" ")
      .reduce([] of Int32) do |acc, x|
        x.to_i?.try { |num| acc << num } \
          || OPERATIONS[x]?.try(&.call(acc)) \
          || raise Exception.new
      end
  end

  private def self.inline_definitions(input): String
    res = input.scan(/:(.*?);/)
    return input unless res

    captures = input.scan(/:(.*?);/).map(&.[1])
    reg = input.rpartition(";")[-1]
    definitions = captures.reject(&.nil?)
      .map(&.as(String))
      .map(&.strip.split(" "))
      .map {|x| {x[0], x[1..-1].join(" ")}}
      .to_h
    raise Exception.new if definitions.map(&.[0]).any?(&.to_i?)
    definitions.reduce(reg) {|prog, (k,v)| prog.gsub(k, v)}
  end

  private def self.sum(nums)
    raise Exception.new if nums.size < 2
    [nums.sum]
  end

  private def self.diff(nums)
    raise Exception.new if nums.size < 2
    [nums.reduce {|acc, curr| acc - curr }]
  end

  private def self.product(nums)
    raise Exception.new if nums.size < 2
    [nums.product]
  end

  private def self.division(nums)
    raise Exception.new if nums.size < 2
    [nums.reduce {|acc, curr| acc / curr }]
  end

  private def self.dup(nums)
    nums << nums.last
  end

  private def self.drop(nums)
    raise Exception.new if nums.empty?
    nums[0..-2]
  end

  private def self.swap(nums)
    nums[0..-3] << nums[-1] << nums[-2]
  end

  private def self.over(nums)
    nums << nums[-2]
  end
end
