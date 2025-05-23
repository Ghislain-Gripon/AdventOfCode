package com.ghislaingripon.`2024`.day1.two

import com.ghislaingripon.utils.InputReader.{readInput, splitInput}

object Day1Part2 {

  val result: Int = {
    val inputArray: List[Array[Int]] = readInput(
      "src/main/resources/2024/day1/one/input/input.txt"
    ).map(splitInput)

    val leftList = inputArray.map(_.head)
    val rightList = inputArray.map(_(1))

    leftList.map(i => i * rightList.count(_.equals(i))).sum

  }
}
