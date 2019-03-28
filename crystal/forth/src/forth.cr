module Forth
  extend self

  OPERATIONS = {
    "+"    => ->add(Array(Int32)),
    "-"    => ->sub(Array(Int32)),
    "*"    => ->mult(Array(Int32)),
    "/"    => ->div(Array(Int32)),
    "dup"  => ->dup(Array(Int32)),
    "drop" => ->drop(Array(Int32)),
    "swap" => ->swap(Array(Int32)),
    "over" => ->over(Array(Int32)),
  }

  def evaluate(input) : Array(Int32)
    definitions, program = prepare(input)
    run(program, compile(definitions))
  end

  private def run(program, user_defined_ops)
    program.split(" ")
      .reduce([] of Int32) do |stack, token|
        methodize?(token, stack, user_defined_ops) || evaluate(stack, token)
      end
  end

  private def evaluate(stack : Array(Int32), token : String) : Array(Int32)
    numerize?(token, stack) || methodize?(token, stack, OPERATIONS) || raise Exception.new
  end

  private def numerize?(token, stack)
    token.to_i?.try { |num| stack << num }
  end

  private def methodize?(token, stack, ops)
    ops[token]?.try(&.call(stack))
  end

  private def prepare(input)
    parts = input.downcase.split(";")
    {parts[0..-2], parts[-1]}
  end

  private def compile(definitions : Array(String))
    definitions
      .map { |definition| definition.strip.split(" ")[1..-1] }
      .map { |parts| {parts[0], define_user_op(parts)} }
      .to_h
  end

  private def define_user_op(x) : Proc(Array(Int32), Array(Int32))
    ->(stack : Array(Int32)) do
      x[1..-1].reduce(stack) { |acc, token| evaluate(acc, token) }
    end
  end

  private def add(nums)
    arr, a, b = pop_2(nums)
    arr << a + b
  end

  private def sub(nums)
    arr, a, b = pop_2(nums)
    arr << a - b
  end

  private def mult(nums)
    arr, a, b = pop_2(nums)
    arr << a * b
  end

  private def div(nums)
    arr, a, b = pop_2(nums)
    arr << a / b
  end

  private def dup(nums)
    _, last = pop(nums)
    nums << last
  end

  private def drop(nums)
    pop(nums)[0]
  end

  private def swap(nums)
    arr, a, b = pop_2(nums)
    arr << b << a
  end

  private def over(nums)
    arr, a, _ = pop_2(nums)
    nums << a
  end

  private def pop(nums)
    {nums[0..-2], nums[-1]}
  end

  private def pop_2(nums)
    arr, b = pop(nums)
    arr, a = pop(arr)
    {arr, a, b}
  end
end
