package org.py.scala.test

object TestApp extends App {

  println(args.length)

  def apply(args: List[String]): Unit = {
    println(args)
  }

  apply(List("sdfs"))

}
