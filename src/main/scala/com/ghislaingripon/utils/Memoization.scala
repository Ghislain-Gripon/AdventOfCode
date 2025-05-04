package com.ghislaingripon.utils

import scala.collection.mutable

object Memoization {

  def apply[P, R](f: P => R): P => R = {
    new Memoization[P, R].memoize(f)
  }

}

private class Memoization[P, R] {

  private val cache_map: mutable.HashMap[(P, P => R), R] =
    mutable.HashMap[(P, P => R), R]()

  private def memoize(f: P => R): P => R = (param: P) =>
    cache_map.get((param, f)) match {
      case Some(value) => value
      case None        => cache_map.addOne((param, f), f(param))((param, f))
    }
}
