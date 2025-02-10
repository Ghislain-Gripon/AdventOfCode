package com.ghislaingripon.`2024`.day2.`2`

import com.ghislaingripon.`2024`.day2.`1`.Day2Part1.isReportSafe
import com.ghislaingripon.utils.CmpChain._
import com.ghislaingripon.utils.InputReader.{readInput, splitInput}

import scala.annotation.tailrec
import scala.math.abs

object Day2Part2 {
  val result: Int = {
    val inputArray: List[Array[Int]] = readInput(
      "src/main/resources/2024/day2/1/input/input.txt"
    ).map(splitInput)

    inputArray.map().count(res => res)
  }

  def isReportSafeWithDampener(report: Array[Int]): Boolean =
    isReportSafe(report) match {
      case true  => true
      case false => _isReportSafeWithDampener()
    }

  def unsafeTransitions(report: Array[Int]) = {

  }

  @tailrec
  def _isReportSafeWithDampener(report: Array[Int], indices: Int = 0): Boolean =
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
