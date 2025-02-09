package com.ghislaingripon

import com.ghislaingripon.utils.InputReader.{readInput, splitInput}
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
      val testList: List[String] = List(
        "45 47 48 50 51 52 54 51",
        "23 26 27 30 31",
        "40 41 44 47 49 51 55",
        "12 15 18 19 26",
        "78 81 83 84 83 84",
        "5 7 10 7 4",
        "1 4 5 6 7"
      )
      val list: List[String] =
        readInput("src/test/resources/2024/day2/testInput.txt")

      assert(testList === list)
    }

  }

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

    it("report format") {
      assert(splitInput("34 54 64 76") === Array(34, 54, 64, 76))
    }
  }

}
