package org.py.scala.test

object InnerClassTest {

  def main(args: Array[String]): Unit = {
    val a = new TestA
    val b = new TestA
    val i1 = new a.InnerClass2
    val i2 = new b.InnerClass2
    i1.print(i1)
    i1.print(i2)

  }

}


class TestA {

  class InnerClass2 {
    //类型投影
    def print(innerClass2: TestA#InnerClass2): Unit = {
      // 和外部类对象绑定
      //    def print(innerClass2: InnerClass2): Unit = {
      println(innerClass2)
    }

  }

}

object TestA {

  class InnerClass {

  }

}