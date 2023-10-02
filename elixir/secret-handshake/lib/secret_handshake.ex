defmodule SecretHandshake do
  @doc """
  Determine the actions of a secret handshake based on the binary
  representation of the given `code`.

  If the following bits are set, include the corresponding action in your list
  of commands, in order from lowest to highest.

  1 = wink
  10 = double blink
  100 = close your eyes
  1000 = jump

  10000 = Reverse the order of the operations in the secret handshake
  """
  @spec commands(code :: integer) :: list(String.t())
  def commands(code) do
    list =
      Integer.digits(code, 2)
      |> Enum.reverse()
      |> Enum.with_index()
      |> Enum.map(fn {bit, idx} ->
        if bit == 0 do
          nil
        else
          case idx do
            0 -> "wink"
            1 -> "double blink"
            2 -> "close your eyes"
            3 -> "jump"
            4 -> "reverse"
            _ -> nil
          end
        end
      end)
      |> Enum.filter(fn itm -> itm != nil end)

    if Enum.member?(list, "reverse") do
      reversed = Enum.reverse(list)
      [_ | rest] = reversed
      rest
    else
      list
    end
  end
end
