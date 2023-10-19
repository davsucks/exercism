defmodule BasketballWebsite do
  defp get_helper(data, []), do: data

  defp get_helper(data, [key | rest]) do
    get_helper(data[key], rest)
  end

  def extract_from_path(data, path) do
    keys = String.split(path, ".")
    get_helper(data, keys)
  end

  def get_in_path(data, path) do
    get_in(data, String.split(path, "."))
  end
end
