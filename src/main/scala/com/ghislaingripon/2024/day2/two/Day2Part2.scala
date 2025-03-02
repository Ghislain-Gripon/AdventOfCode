package com.ghislaingripon.`2024`.day2.two

import com.ghislaingripon.`2024`.day2.one.Day2Part1.isReportSafe
import com.ghislaingripon.utils.CmpChain._
import com.ghislaingripon.utils.InputReader.{readInput, splitInput}

import scala.annotation.tailrec
import scala.language.reflectiveCalls
import scala.math.abs

object Day2Part2 {
  val result: Int = {
    val inputArray: List[Array[Int]] = readInput(
      "src/main/resources/2024/day2/one/input/input.txt"
    ).map(splitInput)

    inputArray.map(isReportSafeWithDampener).count(res => res)
  }

  private def isReportSafeWithDampener(report: Array[Int]): Boolean =
    isReportSafe(report) match {
      case true  => true
      case false => _isReportSafeWithDampener(report)
    }

  private def _isReportSafeWithDampener(
      report: Array[Int]
  ): Boolean = {
    ???
  }
}
