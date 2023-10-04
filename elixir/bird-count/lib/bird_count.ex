defmodule BirdCount do
  def today(list) do
    List.first(list, nil)
  end

  def increment_day_count([]), do: [1]

  def increment_day_count(list) do
    [today | rest] = list
    [today + 1 | rest]
  end

  def has_day_without_birds?(list) do
    Enum.any?(list, &(&1 == 0))
  end

  def total([]), do: 0

  def total([today | rest]) do
    today + total(rest)
  end

  def busy_days([]), do: 0

  def busy_days([today | rest]) when today >= 5 do
    1 + busy_days(rest)
  end

  def busy_days([today | rest]) do
    busy_days(rest)
  end
end
