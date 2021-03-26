package org.py.scala.test

import scala.collection.mutable

object TestSymbol {

  def main(args: Array[String]): Unit = {
    var map: mutable.HashMap[Int, String] = new mutable.HashMap[Int, String]
    map.foreach(a => println(a._1, a._2))
    //    map.foreach(a <- println(a._1, a._2))
    for (i <- map) println(i._1, i._2)
    //    map.foreach()
    map.keySet.foreach(_ => map.get(_))
    //    map.foreach((a,b) -> println(a))
  }

}


