package com.ghislaingripon

import com.ghislaingripon.`2024`.day1.InputReader.{readInput, splitInput}
import org.scalatest.funspec.AnyFunSpec

class DifferenceCalculationTest extends AnyFunSpec {

  describe("The Input should be split correctly with") {
    it("one space") {
      assert(splitInput("1 2") === Array(1, 2))
    }

    it("multiple space") {
      assert(splitInput("3   4") === Array(3, 4))
    }

    it("trailing line return") {
      assert(splitInput("""3   3
          |""".stripMargin) === Array(3, 3))
    }
  }

  describe("The difference") {
    it("should be correct") {
      val inputTestList = readInput("src/test/resources/testInput.txt").map(splitInput)

      val leftList = inputTestList.map(_.head).sorted
      val rightList = inputTestList.map(_(1)).sorted

      val distance = leftList.zipWithIndex.map(array => Math.abs(array._1 - rightList(array._2))).sum

      assert(distance === 11)
    }
  }

}
