defmodule RationalNumbers do
  @type rational :: {integer, integer}

  @doc """
  Add two rational numbers
  """
  @spec add(a :: rational, b :: rational) :: rational
  def add({a_1, b_1}, {a_2, b_2}) do
    RationalNumbers.reduce({a_1 * b_2 + a_2 * b_1, b_1 * b_2})
  end

  @doc """
  Subtract two rational numbers
  """
  @spec subtract(a :: rational, b :: rational) :: rational
  def subtract({a_1, b_1}, {a_2, b_2}) do
    RationalNumbers.reduce({a_1 * b_2 - a_2 * b_1, b_1 * b_2})
  end

  @doc """
  Multiply two rational numbers
  """
  @spec multiply(a :: rational, b :: rational) :: rational
  def multiply({a_1, b_1}, {a_2, b_2}) do
    RationalNumbers.reduce({a_1 * a_2, b_1 * b_2})
  end

  @doc """
  Divide two rational numbers
  """
  @spec divide_by(num :: rational, den :: rational) :: rational
  def divide_by({a_1, b_1}, {a_2, b_2}) do
    RationalNumbers.reduce({a_1 * b_2, a_2 * b_1})
  end

  @doc """
  Absolute value of a rational number
  """
  @spec abs(a :: rational) :: rational
  def abs({num, denom}) do
    RationalNumbers.reduce({Kernel.abs(num), Kernel.abs(denom)})
  end

  @doc """
  Exponentiation of a rational number by an integer
  """
  @spec pow_rational(a :: rational, n :: integer) :: rational
  def pow_rational({a, b}, n) when n < 0 do
    m = Kernel.abs(n)
    RationalNumbers.reduce({b ** m, a ** m})
  end
  def pow_rational({a, b}, n) when n >= 0 do
    RationalNumbers.reduce({a ** n, b ** n})
  end

  @doc """
  Exponentiation of a real number by a rational number
  """
  @spec pow_real(x :: integer, n :: rational) :: float
  def pow_real(x, {a, b}) do
    (x ** a) ** (1/b)
  end

  @doc """
  Reduce a rational number to its lowest terms
  """
  @spec reduce(a :: rational) :: rational
  def reduce({num, denom}) do
    gcd = Integer.gcd(num, denom)
    new_num = num / gcd
    new_denom = denom / gcd

    if new_denom < 0 do
      {new_num * -1, new_denom * -1}
    else
      {new_num, new_denom}
    end
  end
end
