defmodule FreelancerRates do
  @billable_days_in_month 22

  defp to_percentage(val) do
    val / 100
  end

  def daily_rate(hourly_rate) do
    8.0 * hourly_rate
  end

  def apply_discount(before_discount, discount) do
    before_discount * (1 - to_percentage(discount))
  end

  def monthly_rate(hourly_rate, discount) do
    rate = daily_rate(hourly_rate) * @billable_days_in_month
    ceil(apply_discount(rate, discount))
  end

  def days_in_budget(budget, hourly_rate, discount) do
    discounted_rate = apply_discount(daily_rate(hourly_rate), discount)
    Float.floor(budget / discounted_rate, 1)
  end
end
