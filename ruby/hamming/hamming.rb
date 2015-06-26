class IncomparableStrandsError < ArgumentError
end

# Strand is used to represent the domain concept of a strand of DNA
class Strand
  def initialize(sequence)
    @sequence = sequence
  end

  def nucleotides
    @sequence.chars
  end

  def length
    @sequence.length
  end
end

# Hamming contains one static method to compute the hamming number of
#   two strands
class Hamming
  VERSION = 1

  def self.compute(string_one, string_two)
    strand_one = Strand.new(string_one)
    strand_two = Strand.new(string_two)
    fail IncomparableStrandsError if strand_one.length != strand_two.length
    count_mutations(strand_one, strand_two)
  end

  def self.count_mutations(strand_one, strand_two)
    combined_strands = strand_one.nucleotides.zip(strand_two.nucleotides)
    combined_strands.count do |nucleotide_one, nucleotide_two|
      nucleotide_one != nucleotide_two
    end
  end
end
