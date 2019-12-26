defmodule RNATranscription do
  @doc """
  Transcribes a character list representing DNA nucleotides to RNA

  ## Examples

  iex> RNATranscription.to_rna('ACTG')
  'UGAC'
  """
  @spec to_rna([char]) :: [char]
  def to_rna(dna) do
    lookup = %{
      71 => 67, 
      67 => 71, 
      84 => 65, 
      65 => 85
    }
    Enum.map(dna, fn(x) -> lookup[x] end)
  end
end
