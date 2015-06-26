class Gigasecond
  VERSION = 1
  ONE_GIGASECOND = 1e9

  def self.from(time)
    time + ONE_GIGASECOND
  end
end
