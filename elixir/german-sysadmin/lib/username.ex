defmodule Username do
  @spec sanitize(username :: charlist()) :: charlist()
  def sanitize([]), do: []

  def sanitize([first | rest]) do
    case first do
      first when ?a <= first and ?z >= first -> [first] ++ sanitize(rest)
      first when first == ?_ -> [first] ++ sanitize(rest)
      first when first == ?ä -> ~c"ae" ++ sanitize(rest)
      first when first == ?ö -> ~c"oe" ++ sanitize(rest)
      first when first == ?ü -> ~c"ue" ++ sanitize(rest)
      first when first == ?ß -> ~c"ss" ++ sanitize(rest)
      _ -> sanitize(rest)
    end
  end
end
