require 'Prime'

# Raindrops converts a number to a string based off the number's prime factorization.
#   If the number's prime factorization includes 3, the string contains "Pling"
#   If the number's prime factorization includes 5, the string contains "Plang"
#   If the number's prime factorization includes 7, the string contains "Plong"
#   Otherwise, the string is simply the nubmer
class Raindrops
  def self.convert(number)
    prime_factors = pluck_factors_from_prime_factorization(number)

    raindrops = ''
    raindrops << 'Pling' if prime_factors.include? 3
    raindrops << 'Plang' if prime_factors.include? 5
    raindrops << 'Plong' if prime_factors.include? 7

    raindrops.empty? ? number.to_s : raindrops
  end

  def self.pluck_factors_from_prime_factorization(number)
    Prime.prime_division(number).map { |factor_exp_ary| factor_exp_ary[0] }
  end
  private_class_method :pluck_factors_from_prime_factorization
end
