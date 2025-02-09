package com.ghislaingripon.`2024`.day2.`1`

import com.ghislaingripon.utils.InputReader.{readInput, splitInput}

import scala.annotation.tailrec

object Day2Part1 {
  val result: Int = {

    val inputArray: List[Array[Int]] = readInput(
      "src/main/resources/2024/day2/1/input/input.txt"
    ).map(splitInput)



  }

  def isReportSafe(report: Array[Int]): Boolean = {
    _isReportSafe(report)
  }

  @tailrec
  def _isReportSafe(report: Array[Int], indices: Int = 0): Boolean = report match {
      case report if report.length == indices + 1 => true
      case report if report(indices) > report(indices + 1) > report(indices + 2)  =>


  }




}
