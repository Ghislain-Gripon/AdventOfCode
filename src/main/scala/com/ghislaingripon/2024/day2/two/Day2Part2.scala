package com.ghislaingripon.`2024`.day2.two

import com.ghislaingripon.`2024`.day2.one.Day2Part1.isReportSafe
import com.ghislaingripon.utils.InputReader.{readInput, splitInput}

import scala.language.{postfixOps, reflectiveCalls}

object Day2Part2 {
  val result: Int = {
    val inputArray: List[Array[Int]] = readInput(
      "src/main/resources/2024/day2/one/input/input.txt"
    ).map(splitInput)

    inputArray.map(isReportSafeWithDampener).count(identity)
  }

  private def isReportSafeWithDampener(report: Array[Int]): Boolean =
    if (isReportSafe(report)) {
      true
    } else {
      report.indices map ((i: Int) =>
        isReportSafe(report.take(i) ++ report.drop(i + 1))
      ) exists identity
    }

}
