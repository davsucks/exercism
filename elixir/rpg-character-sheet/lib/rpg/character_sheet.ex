defmodule RPG.CharacterSheet do
  def welcome() do
    IO.puts("Welcome! Let's fill out your character sheet together.")
  end

  defp ask_for(attribute), do: String.trim(IO.gets("What is your character's #{attribute}?\n"))

  def ask_name(), do: ask_for("name")

  def ask_class(), do: ask_for("class")

  def ask_level(), do: elem(Integer.parse(ask_for("level")), 0)

  def run() do
    welcome()
    character = %{name: ask_name(), class: ask_class(), level: ask_level()}
    IO.inspect(character, label: "Your character")
  end
end
