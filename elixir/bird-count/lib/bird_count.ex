defmodule BirdCount do
  def today([]), do: nil

  def today([today | _]) do
    today
  end

  def increment_day_count([]), do: [1]

  def increment_day_count(list) do
    [today | rest] = list
    [today + 1 | rest]
  end

  def has_day_without_birds?([]), do: false
  def has_day_without_birds?([0 | _]), do: true

  def has_day_without_birds?([_ | rest]) do
    false || has_day_without_birds?(rest)
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
