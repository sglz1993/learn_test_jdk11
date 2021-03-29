package org.py.scala.test

object TestTrait {

  def main(args: Array[String]): Unit = {
    //    var bb: CC with BB = new CC with BB
    //    println()
    //    println()
    //    println()
    //    bb.hello()
    //
    //    bb.lal()
    //    bb.slsl()
    val d = new D

  }

}

trait A1 {
  println("create A1")

  def hello() = {
    println("hello A1")
  }

  //  def hello()
}

trait Aim extends A1 {
  println("create A")

  override abstract def hello(): Unit = {
    println("hello A")
    super.hello()
  }
}

trait B extends Aim {
  println("create B")

  def slsl();

  override abstract def hello(): Unit = {
    println("hello B")
    super.hello()
  }
}

trait C extends Aim {
  println("create C")

  override def hello(): Unit = {
    println("hello C")
    super.hello()
  }
}

trait BB extends B {


  println("create BB")

  override def slsl(): Unit = println("ss")

  override def hello(): Unit = {
    println("hello BB")
    super.hello()
  }
}

abstract class CC extends C {
  println("create CC")

  override def hello(): Unit = {
    println("hello CC")
    super.hello()
  }
}

class D extends CC with BB {
  println("create D")

  def lal(): Unit = {
    println("lal")
  }
}

class E {
  def e(): Unit = {

  }
}

/**
 * illegal inheritance; superclass E
 * is not a subclass of the superclass D
 * of the mixin trait BB
 * class F extends E with BB {
 */
class F extends E with BB {

}


