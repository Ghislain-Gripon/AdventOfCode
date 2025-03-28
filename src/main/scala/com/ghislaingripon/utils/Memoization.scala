package com.ghislaingripon.utils

import scala.collection.mutable

object Memoization {

  private def cache[P, R]: mutable.HashMap[(P, P => R), R] = mutable.HashMap[(P, P => R), R]()

  def memoize[P, R](f: P => R): P => R = (param: P) =>
    cache.get((param, f)) match {
      case Some((value, _)) => value
      case None        => cache.addOne((param, f), f(param))((param, f))
    }


}
