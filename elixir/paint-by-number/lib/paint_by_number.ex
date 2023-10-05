defmodule PaintByNumber do
  defp log(search, count \\ 1) do
    if Integer.pow(2, count) >= search do
      count
    else
      log(search, count + 1)
    end
  end

  def palette_bit_size(color_count) do
    log(color_count)
  end

  def empty_picture() do
    <<>>
  end

  def test_picture() do
    <<0::2, 1::2, 2::2, 3::2>>
  end

  def prepend_pixel(picture, color_count, pixel_color_index) do
    <<pixel_color_index::size(palette_bit_size(color_count)), picture::bitstring>>
  end

  def get_first_pixel(<<>>, _), do: nil

  def get_first_pixel(picture, color_count) do
    num_bits = palette_bit_size(color_count)
    <<first_pixel::size(num_bits), _::bitstring>> = picture
    first_pixel
  end

  def drop_first_pixel(<<>>, _), do: <<>>

  def drop_first_pixel(picture, color_count) do
    num_bits = palette_bit_size(color_count)
    <<_::size(num_bits), rest::bitstring>> = picture
    rest
  end

  def concat_pictures(picture1, picture2) do
    <<picture1::bitstring, picture2::bitstring>>
  end
end
