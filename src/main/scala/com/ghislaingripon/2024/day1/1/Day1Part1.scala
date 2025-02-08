package com.ghislaingripon.`2024`.day1.`1`

import com.ghislaingripon.`2024`.day1.InputReader.{readInput, splitInput}

object Day1Part1 {

  val result: Int = {
    val inputArray: List[Array[Int]] = readInput(
      "src/main/resources/2024/day1/1/input/input.txt"
    ).map(splitInput)

    val leftList = inputArray.map(_.head).sorted
    val rightList = inputArray.map(_(1)).sorted

    val distance = leftList.zipWithIndex
      .map(array => Math.abs(array._1 - rightList(array._2)))
      .sum

    distance
  }

}
