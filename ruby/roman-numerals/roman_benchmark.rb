require 'Benchmark'
require_relative 'roman_numerals'

10.times do 
  puts Benchmark.measure {
    50000.times do |n|
      n.to_roman
    end
  }
end