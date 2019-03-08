defmodule Bob do
  def hey(input) do
    cond do
      silence?(input) -> "Fine. Be that way!"
      shouting?(input) && questioning?(input) -> "Calm down, I know what I'm doing!"
      questioning?(input) -> "Sure."
      shouting?(input) -> "Whoa, chill out!"
      true -> "Whatever."
    end
  end

  defp shouting?(input) do
    upped = String.upcase(input)
    downed = String.downcase(input)
    input == upped && upped != downed
  end

  defp questioning?(input) do
    String.ends_with?(input, "?")
  end

  defp silence?(input) do
    String.trim(input) == ""
  end
end
