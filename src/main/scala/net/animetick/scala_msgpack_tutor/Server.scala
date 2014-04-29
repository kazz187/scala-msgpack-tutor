package net.animetick.scala_msgpack_tutor

import org.msgpack.scalarpc.ScalaServer

import org.msgpack.scalarpc.ScalaClient
import org.msgpack.annotation.Message
import org.msgpack.MessagePack

/**
 * Created by kazz on 2014/04/19.
 */
object Server {
  def main(args: Array[String]): Unit = {
    @Message
    class TutorialProtocol {
      var id: Integer = 0
      var name: String = ""
    }

    class TutorialServer {
      def hello(int_val: Int, list: List[Integer], map: Map[String, String]): String = {
        val result = "called hello: " + int_val + " " + list + " " + map
        println(result)
        result
      }
      def call_tutorial(protocol: TutorialProtocol): String = {
        val result = "id: " + protocol.id + "\n" + "name: " + protocol.name
        println(result)
        result
      }
    }
    val port = 12345
    ScalaServer().withServeObject(new TutorialServer()).listen(port)

    // Client
//    trait TutorialInterface {
//      def hello(message: String, value: Int)
//    }
//
//    val client = ScalaClient("localhost", port)
//    val proxy: TutorialInterface = client.proxy[TutorialInterface]
//    proxy.hello("test message", 100)
  }
}
