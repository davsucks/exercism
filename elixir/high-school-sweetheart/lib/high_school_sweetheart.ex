defmodule HighSchoolSweetheart do
  def first_letter(name) do
    String.trim(name) |> String.first()
  end

  def initial(name) do
    HighSchoolSweetheart.first_letter(name) |> String.upcase() |> Kernel.<>(".")
  end

  def initials(full_name) do
    [first | [last]] = String.split(full_name)
    "#{HighSchoolSweetheart.initial(first)} #{HighSchoolSweetheart.initial(last)}"
  end

  def pair(full_name1, full_name2) do
    {initial_one, initial_two} =
      {HighSchoolSweetheart.initials(full_name1), HighSchoolSweetheart.initials(full_name2)}

    """
         ******       ******
       **      **   **      **
     **         ** **         **
    **            *            **
    **                         **
    **     #{initial_one}  +  #{initial_two}     **
     **                       **
       **                   **
         **               **
           **           **
             **       **
               **   **
                 ***
                  *
    """
  end
end
