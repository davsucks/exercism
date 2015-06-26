class InvalidDNAStrand < ArgumentError
end

class InvalidRNAStrand < ArgumentError
end

# If given a DNA or RNA strand, will use appropriate static methods to create the
#   transcription of those strands
class Complement
  DNA_NUCLEOTIDES = %w(C G T A)
  RNA_NUCLEOTIDES = %w(G C A U)
  RNA_COMPLEMENT = {}
  DNA_NUCLEOTIDES.zip(RNA_NUCLEOTIDES) do |dna, complement|
    RNA_COMPLEMENT[dna] = complement
  end

  def self.of_dna(dna_strand)
    fail InvalidDNAStrand unless valid_strand? dna_strand, DNA_NUCLEOTIDES

    replace_nucleotides_in_strand(dna_strand, DNA_NUCLEOTIDES, RNA_NUCLEOTIDES)
  end

  def self.of_rna(rna_strand)
    fail InvalidRNAStrand unless valid_strand? rna_strand, RNA_NUCLEOTIDES

    replace_nucleotides_in_strand(rna_strand, RNA_NUCLEOTIDES, DNA_NUCLEOTIDES)
  end

  def self.valid_strand?(strand, nucleotides)
    strand.chars.all? do |nucleotide|
      nucleotides.include? nucleotide
    end
  end
  private_class_method :valid_strand?

  def self.replace_nucleotides_in_strand(strand, from_ary, to_ary)
    strand.tr(from_ary.join, to_ary.join)
  end
  private_class_method :replace_nucleotides_in_strand
end
