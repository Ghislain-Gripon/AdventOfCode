package com.ghislaingripon

import com.ghislaingripon.utils.InputReader.readInput
import org.scalatest.funspec.AnyFunSpec

class ReadingInputTest extends AnyFunSpec {

  describe("The input") {
    it("for day 1 should be read correctly") {
      val testList: List[String] =
        List("3   4", "4   3", "2   5", "1   3", "3   9", "3   3")
      val list: List[String] = readInput("src/test/resources/testInput.txt")

      assert(testList === list)
    }

    it("for day 2 should be read correctly") {
      val testList: List[String] =
    }

  }

}
