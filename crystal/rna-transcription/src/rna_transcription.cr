module RnaComplement
  CONVERSION = {'C' => 'G', 'G' => 'C', 'T' => 'A', 'A' => 'U'}

  def self.of_dna(strand)
    strand.chars.map { |x| CONVERSION[x] }.join("")
  end
end