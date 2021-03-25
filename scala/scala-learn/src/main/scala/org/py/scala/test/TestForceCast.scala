package org.py.scala.test

object TestForceCast {

  /**
   * update
   * update
   * true
   * true
   *
   * @param args
   */
  def main(args: Array[String]): Unit = {
    var b:B = new BB
    if (b.isInstanceOf[BB]) {
      val value = b.asInstanceOf[BB]
      value.a.name = "update"
      println(value.a.name)
      println(b.a.name)
      println(value == b)
      println(value.a == b.a)
    }
  }

}


class A {
  var name = "A"
}

class BB extends B {

}

class B {
  var a = new A
}
