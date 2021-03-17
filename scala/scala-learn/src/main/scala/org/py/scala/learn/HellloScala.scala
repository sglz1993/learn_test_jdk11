package org.py.scala.learn

class HellloScala {

}

object HellloScala {

  def getPerson(): (String, Int) = {
    ("name12", 10)
  }

  /**
   * lalalaal
   * @example sdfsdf
   *            sdfsdf
   * @param args sfsdf
   */
  def main(args: Array[String]): Unit = {
    println("hello scala")
    val (name, age) = getPerson()
    println(name + "  :  " + age)
    var a = 10
    a = 12
  }



}
