defmodule GuessingGame do
  def compare(secret_number, guess \\ :no_guess)
  def compare(_, :no_guess), do: "Make a guess"
  def compare(secret_number, guess) when secret_number == guess, do: "Correct"

  def compare(secret_number, guess)
      when guess + 1 == secret_number or guess - 1 == secret_number do
    "So close"
  end

  def compare(secret_number, guess) when guess > secret_number, do: "Too high"
  def compare(secret_number, guess) when guess < secret_number, do: "Too low"
end
