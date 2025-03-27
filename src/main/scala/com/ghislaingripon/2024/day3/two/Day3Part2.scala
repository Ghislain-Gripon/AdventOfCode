package com.ghislaingripon.`2024`.day3.two

import com.ghislaingripon.utils.InputReader.readInput

import scala.annotation.tailrec
import scala.util.matching.{Regex, UnanchoredRegex}

object Day3Part2 {

  private val parser: UnanchoredRegex =
    raw"mul\((\d{1,3}),(\d{1,3})\)|(do\(\))|(don't\(\))".r.unanchored

  val result: Long = {

    findNumbersInInput(readInput(
      "src/main/resources/2024/day3/one/input/input.txt"
    ).mkString.transform(parser.findAllMatchIn))

//    readInput(
//      "src/main/resources/2024/day3/one/input/input.txt"
//    ).map(parser.findAllMatchIn)
//      .map((m: Iterator[Regex.Match]) => findNumbersInInput(m))
//      .sum

  }

  @tailrec
  private def findNumbersInInput(
      matches: Iterator[Regex.Match],
      mulEnabled: Boolean = true,
      accumulator: Long = 0
  ): Long = if (matches.hasNext) {
    val result: (Int, Boolean) = matches.next() match {
      case parser(x, y, null, null) =>
        if (mulEnabled)
          (x.toInt * y.toInt, mulEnabled)
        else (0, mulEnabled)

      case parser(null, null, "do()", null) =>
        (0, true)

      case parser(null, null, null, "don't()") =>
        (0, false)
    }
    findNumbersInInput(matches, result._2, accumulator + result._1)
  } else {
    accumulator
  }

}
