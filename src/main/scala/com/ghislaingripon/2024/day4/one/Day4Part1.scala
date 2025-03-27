package com.ghislaingripon.`2024`.day4.one

import com.ghislaingripon.utils.CmpChain.ordToCmpChain
import com.ghislaingripon.utils.InputReader.readInput

import scala.annotation.tailrec
import scala.language.{postfixOps, reflectiveCalls}

object Day4Part1 {

  private val xmasChecks: List[List[(Char, (Int, Int))]] = List(
    List('M' -> (0, 1), 'A' -> (0, 2), 'S' -> (0, 3)),
    List('M' -> (0, -1), 'A' -> (0, -2), 'S' -> (0, -3)),
    List('M' -> (1, 0), 'A' -> (2, 0), 'S' -> (3, 0)),
    List('M' -> (-1, 0), 'A' -> (-2, 0), 'S' -> (-3, 0)),
    List('M' -> (1, 1), 'A' -> (2, 2), 'S' -> (3, 3)),
    List('M' -> (-1, -1), 'A' -> (-2, -2), 'S' -> (-3, -3)),
    List('M' -> (-1, 1), 'A' -> (-2, 2), 'S' -> (-3, 3)),
    List('M' -> (1, -1), 'A' -> (2, -2), 'S' -> (3, -3))
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
          if (letter == 'X' && 6.cmp <= x + 3 < input.length && 6.cmp <= y + 3 < outerArray.length)
            xmasChecks.map(checkForXmas(_)(input, (x, y))).count(identity)
          else 0
        }
    }

    xmasPerIndice.flatten.sum

  }

  @tailrec
  def checkForXmas(
      checkDirection: List[(Char, (Int, Int))]
  )(implicit input: Array[Array[Char]], indicesOfX: (Int, Int)): Boolean =
    checkDirection match {
      case Nil => true
      case check :: tail =>
        input(indicesOfX._1 + check._2._1)(
          indicesOfX._2 + check._2._2
        ) == check._1 && checkForXmas(tail)
    }

  def padInput(input: Array[Array[Char]]): Array[Array[Char]] =
    input
      .map(Array.fill(3)(' ') ++ _ ++ Array.fill(3)(' '))
      .appended(Array.fill(input.length + 6)(' '))
      .appended(Array.fill(input.length + 6)(' '))
      .appended(Array.fill(input.length + 6)(' '))
      .prepended(Array.fill(input.length + 6)(' '))
      .prepended(Array.fill(input.length + 6)(' '))
      .prepended(Array.fill(input.length + 6)(' '))

}
