name := "scala-redis-tutor"

version := "1.0"

resolvers += "msgpack_repos" at "http://msgpack.org/maven2/"

libraryDependencies ++= Seq(
  "com.typesafe" %% "scalalogging-slf4j" % "1.0.1",
  "ch.qos.logback" % "logback-classic" % "1.0.13",
  "org.specs2" %% "specs2" % "2.3.6" % "test",
  "org.msgpack" %% "msgpack-rpc-scala" % "0.6.8-SNAPSHOT"
)
