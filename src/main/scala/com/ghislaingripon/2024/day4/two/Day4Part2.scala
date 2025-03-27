package com.ghislaingripon.`2024`.day4.two

import com.ghislaingripon.`2024`.day4.one.Day4Part1.{checkForXmas, padInput}
import com.ghislaingripon.utils.CmpChain.ordToCmpChain
import com.ghislaingripon.utils.InputReader.readInput

import scala.language.reflectiveCalls

object Day4Part2 {
  private val xmasChecks: List[List[(Char, (Int, Int))]] = List(
    List('M' -> (-1, -1), 'M' -> (1, -1), 'S' -> (-1, 1), 'S' -> (1, 1)),
    List('M' -> (-1, -1), 'M' -> (-1, 1), 'S' -> (1, -1), 'S' -> (1, 1)),
    List('M' -> (1, -1), 'M' -> (1, 1), 'S' -> (-1, -1), 'S' -> (-1, 1)),
    List('M' -> (-1, 1), 'M' -> (1, 1), 'S' -> (-1, -1), 'S' -> (1, -1))
  )

  val result: Int = {
    val input: Array[Array[Char]] = padInput(
      readInput(
        "src/main/resources/2024/day4/one/input/input.txt"
      ).map((_: String).toCharArray).toArray
    )

    val xmasPerIndice: Array[Array[Int]] = input.zipWithIndex.map {
      case (outerArray, x) =>
        outerArray.zipWithIndex.map { case (letter, y) =>
          if (
            letter == 'A' && 6.cmp <= x + 3 < input.length && 6.cmp <= y + 3 < outerArray.length
          )
            xmasChecks.map(checkForXmas(_)(input, (x, y))).count(identity)
          else 0
        }
    }

    xmasPerIndice.flatten.sum
  }
}
