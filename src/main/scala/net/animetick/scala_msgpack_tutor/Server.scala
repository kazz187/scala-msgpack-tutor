package net.animetick.scala_msgpack_tutor

import org.msgpack.scalarpc.ScalaServer

import org.msgpack.scalarpc.ScalaClient

/**
 * Created by kazz on 2014/04/19.
 */
object Server {
  def main(args: Array[String]): Unit = {
    class TutorialServer {
      def hello(message: String, value: Int) {
        println("called hello: " + message + " " + value)
        sys.exit(1)
      }
    }
    val port = 12345
    ScalaServer().withServeObject(new TutorialServer()).listen(port)

    // Client
    trait TutorialInterface {
      def hello(message: String, value: Int)
    }

    val client = ScalaClient("localhost", port)
    val proxy: TutorialInterface = client.proxy[TutorialInterface]
    proxy.hello("test message", 100)
  }
}
