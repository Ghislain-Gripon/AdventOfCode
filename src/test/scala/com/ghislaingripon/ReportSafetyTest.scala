package com.ghislaingripon

import com.ghislaingripon.utils.InputReader.{readInput, splitInput}
import com.ghislaingripon.`2024`.day2.one.Day2Part1.isReportSafe

import org.scalatest.funspec.AnyFunSpec

class ReportSafetyTest extends AnyFunSpec {

  describe("The reports") {
    it("should be safe when there is only one number") {
      val testInput: Array[Int] = Array(1)
      val result: Boolean = true

      assertResult(result)(isReportSafe(testInput))
    }

    it("should be safe when the report is increasing") {
      val testInput: Array[Int] = Array(1, 2, 3, 4, 5)
      val result: Boolean = true

      assertResult(result)(isReportSafe(testInput))
    }

    it("should be safe when the report is decreasing") {
      val testInput: Array[Int] = Array(40, 38, 37, 34, 32)
      val result: Boolean = true

      assertResult(result)(isReportSafe(testInput))
    }

    it("should be unsafe when the report has two identical consecutive numbers") {
      val testInput: Array[Int] = Array(1, 2, 2, 4, 5)
      val result: Boolean = false

      assertResult(result)(isReportSafe(testInput))
    }

    it("should be unsafe when the report has a difference bigger than 3 between numbers") {
      val testInput: Array[Int] = Array(1, 2, 2, 4, 8)
      val result: Boolean = false

      assertResult(result)(isReportSafe(testInput))
    }

    it("should be unsafe when the report increases then decreases") {
      val testInput: Array[Int] = Array(1, 2, 4, 3, 1)
      val result: Boolean = false

      assertResult(result)(isReportSafe(testInput))
    }
  }

  describe("The test input") {
    it("should be analysed correctly") {
      val testInput: List[Array[Int]] =
        readInput("src/test/resources/2024/day2/testInput.txt").map(splitInput)
      val result: List[Boolean] =
        List(false, true, false, false, false, false, true)

      assertResult(result)(testInput.map(isReportSafe))
    }
  }
}
