package com.ghislaingripon.utils

import scala.io.{BufferedSource, Source}

object InputReader {

  def readInput(filePath: String): List[String] = {
    val inputStream: BufferedSource = Source.fromFile(filePath)
    val lines: List[String] = inputStream.getLines().toList
    inputStream.close()
    lines
  }

  def splitInput(input: String): Array[Int] = {
    splitInput(input, "\\s+")
  }

  def splitInput(input: String, splitPattern: String): Array[Int] = {
    input.split(splitPattern).map(_.toInt)
  }
}
