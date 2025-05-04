package com.ghislaingripon.utils

import org.scalatest.funspec.AnyFunSpec

import scala.language.postfixOps

class MemoizationTest extends AnyFunSpec {
  describe("the memoized function") {
    it("should add its value in cache") {
      var x = 2
      def f(z: Int): Int = {
        x += z
        x
      }

      val f_prime = Memoization(f)

      assert(f_prime(3) === 5)
      x = 3
      assert(f_prime(3) === 5)
      assert(x === 3)
    }
  }

  it("should work with reference types") {
    def f(l: List[Any]): Array[Any] = l.toArray

    val f_prime = Memoization(f)

    assert(f_prime(List(1, 2)) === Array(1, 2))
  }

}
