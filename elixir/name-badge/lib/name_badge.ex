defmodule NameBadge do
  def print(id, name, department) do
    printable_dept = if department == nil, do: "OWNER", else: String.upcase(department)

    if id == nil do
      "#{name} - #{printable_dept}"
    else
      "[#{id}] - #{name} - #{printable_dept}"
    end
  end
end
