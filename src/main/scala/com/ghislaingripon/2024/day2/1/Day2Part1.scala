package com.ghislaingripon.`2024`.day2.`1`

import com.ghislaingripon.utils.InputReader.{readInput, splitInput}
import com.ghislaingripon.utils.CmpChain._

import scala.annotation.tailrec
import scala.language.{implicitConversions, reflectiveCalls}
import scala.math.abs

object Day2Part1 {
  val result: Int = {

    val inputArray: List[Array[Int]] = readInput(
      "src/main/resources/2024/day2/1/input/input.txt"
    ).map(splitInput)

    inputArray.map(isReportSafe).count(res => res)

  }

  def isReportSafe(report: Array[Int]): Boolean = {
    _isReportSafe(report)
  }

  @tailrec
  def _isReportSafe(report: Array[Int], indices: Int = 0): Boolean =
    report match {
      case report if report.length == 1 => true
      case report
          if report.length == indices + 2 & 1.cmp <= abs(
            abs(report(indices) - report(indices + 1))
          ) <= 3 =>
        true
      case report
          if report(indices).cmp > report(indices + 1) > report(indices + 2)
            & 1.cmp <= abs(report(indices) - report(indices + 1)) <= 3
            & 1.cmp <= abs(report(indices + 1) - report(indices + 2)) <= 3 =>
        _isReportSafe(report, indices + 1)
      case report
          if report(indices).cmp < report(indices + 1) < report(indices + 2)
            & 1.cmp <= abs(report(indices) - report(indices + 1)) <= 3
            & 1.cmp <= abs(report(indices + 1) - report(indices + 2)) <= 3 =>
        _isReportSafe(report, indices + 1)
      case _ => false
    }

}
