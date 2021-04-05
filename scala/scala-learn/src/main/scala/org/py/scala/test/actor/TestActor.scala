package org.py.scala.test.actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

object TestActor {

  def main(args: Array[String]): Unit = {

  }

}

class MyActor extends Actor {
  private val myserverRef: ActorRef = context.actorOf(Props[MyActorServer], "myserverRef")

  override def receive: Receive = {
    case a => {
      println("hello my " + a)
      myserverRef ! a
    }
  }
}

object MyActorApp extends App {
  private val actorSystem: ActorSystem = ActorSystem("MyActor")
  private val myactor_ref: ActorRef = actorSystem.actorOf(Props[MyActor], "myactor_ref")
  myactor_ref.!("lalla~~~")

}

class MyActorServer extends Actor {
  override def receive: Receive = {
    case a => {
      println("hello " + a)
      sender() ! "hello"
    }
  }
}

