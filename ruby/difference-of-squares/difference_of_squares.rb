# Finds the difference between the sum of the squares and the square of the sums
#   of the first N natural numbers
class Squares
  def initialize(count)
    @first_n_numbers = (0..count)
  end

  def square_of_sums
    sum_of_the_first_n_numbers ** 2
  end

  def sum_of_squares
    @first_n_numbers.inject(0) do |sum, number|
      sum += number ** 2
    end
  end

  def difference
    square_of_sums - sum_of_squares
  end

  private

  def sum_of_the_first_n_numbers
    @first_n_numbers.reduce(:+)
  end
end
