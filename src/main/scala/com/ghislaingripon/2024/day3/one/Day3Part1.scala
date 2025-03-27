package com.ghislaingripon.`2024`.day3.one

import com.ghislaingripon.utils.InputReader.readInput

object Day3Part1 {
  val result: Int = {
    findNumbersInInput(readInput(
      "src/main/resources/2024/day3/one/input/input.txt"
    ).mkString).map{ case (x: Int, y: Int) => x * y }.sum
  }

  private def findNumbersInInput(input: String): List[(Int, Int)] = {
    (for (
      m <- raw"mul\((\d{1,3}),(\d{1,3})\)".r.unanchored.findAllMatchIn(input)
    )
      yield (m.group(1).toInt, m.group(2).toInt)).toList
  }
}
