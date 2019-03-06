defmodule Bob do
  def hey(input) do
    cond do
      silence(input) -> "Fine. Be that way!"
      shouting(input) && questioning(input) -> "Calm down, I know what I'm doing!"
      questioning(input) -> "Sure."
      shouting(input) -> "Whoa, chill out!"
      true -> "Whatever."
    end
  end

  defp shouting(input) do
    contains_letters(input) && String.upcase(input) == input
  end

  defp questioning(input) do
    String.ends_with?(input, "?")
  end

  defp silence(input) do
    String.trim(input) == ""
  end

  defp contains_letters(input) do
    Regex.match?(~r/\p{L}/, input)
  end
end
