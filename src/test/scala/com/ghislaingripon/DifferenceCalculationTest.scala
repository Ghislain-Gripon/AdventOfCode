package com.ghislaingripon

import com.ghislaingripon.utils.InputReader.{readInput, splitInput}
import org.scalatest.funspec.AnyFunSpec

class DifferenceCalculationTest extends AnyFunSpec {

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
