module Enumerable
  def accumulate(&block)
    return self unless block

    results = []
    each do |item|
      results << yield(item)
    end
    results
  end
end
