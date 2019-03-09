defmodule Words do
  @doc """
  Count the number of words in the sentence.

  Words are compared case-insensitively.
  """
  @spec count(String.t()) :: map
  def count(sentence) do
    sentence
      |> String.downcase()
      |> String.split([" ", "_"])
      |> Enum.map(&(remove_symbols_if_not_in_word(&1)))
      |> Enum.filter(&(&1 != ""))
      |> Enum.reduce(%{}, fn x, acc -> increment_or_put(acc, x) end)
  end

  def increment_or_put(map, key) do
    Map.update(map, key, 1, &(&1 + 1))
  end

  def remove_symbols_if_not_in_word(str) do
    if String.contains?(str, "-") do
      str
    else
      String.replace(str, ~r/[\p{P}\p{S}]/u, "")
    end
  end
end
