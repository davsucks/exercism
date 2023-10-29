defmodule BoutiqueInventory do
  def sort_by_price(inventory) do
    Enum.sort_by(inventory, &(&1.price))
  end

  def with_missing_price(inventory) do
    Enum.filter(inventory, &(&1.price == nil))
  end

  def update_names(inventory, old_word, new_word) do
    Enum.map(inventory, fn item ->
      {_, new_item} =
        Map.get_and_update(item, :name, fn current_value ->
          {current_value, String.replace(current_value, old_word, new_word)}
        end)

      new_item
    end)
  end

  def increase_quantity(item, count) do
    {_, new_item} =
      Map.get_and_update(item, :quantity_by_size, fn current_value ->
        {current_value, Map.new(current_value, fn {key, val} -> {key, val + count} end)}
      end)

    new_item
  end

  def total_quantity(item) do
    Enum.reduce(item.quantity_by_size, 0, fn {_, val}, acc -> acc + val end)
  end
end
