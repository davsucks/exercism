defmodule LibraryFees do
  def datetime_from_string(string) do
    NaiveDateTime.from_iso8601!(string)
  end

  def before_noon?(datetime) do
    Time.compare(NaiveDateTime.to_time(datetime), ~T[12:00:00]) == :lt
  end

  def return_date(checkout_datetime) do
    days = if before_noon?(checkout_datetime), do: 28, else: 29
    NaiveDateTime.add(checkout_datetime, days, :day) |> NaiveDateTime.to_date()
  end

  def days_late(planned_return_date, actual_return_datetime) do
    return_date = NaiveDateTime.to_date(actual_return_datetime)

    max(Date.diff(return_date, planned_return_date), 0)
  end

  def monday?(datetime) do
    NaiveDateTime.to_date(datetime) |> Date.day_of_week() == 1
  end

  def calculate_late_fee(checkout, return, rate) do
    return_datetime = datetime_from_string(return)
    checkout_datetime = datetime_from_string(checkout)

    discount = if monday?(return_datetime), do: 0.5, else: 1.0
    days_late = days_late(return_date(checkout_datetime), return_datetime)
    trunc(Float.floor(days_late * rate * discount))
  end
end
