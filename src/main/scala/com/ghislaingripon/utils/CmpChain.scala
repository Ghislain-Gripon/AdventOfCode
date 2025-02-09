package com.ghislaingripon.utils

import scala.language.implicitConversions

class CmpChain[T](val left: Boolean, x: T)(implicit ev: T => Ordered[T]) {
  def <(y: T) = new CmpChain(left && x < y, y)
  def <=(y: T) = new CmpChain(left && x <= y, y)
  def >(y: T) = new CmpChain(left && x > y, y)
  def >=(y: T) = new CmpChain(left && x >= y, y)

  def asBoolean: Boolean = left
}

object CmpChain {
  implicit def ordToCmpChain[T](x: T)(implicit
      ev: T => Ordered[T]
  ): Object { def cmp: CmpChain[T] } = new AnyRef {
    def cmp = new CmpChain(true, x)
  }

  implicit def rToBoolean[T](cc: CmpChain[T]): Boolean = cc.asBoolean
}
