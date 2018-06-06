def common = Seq(
	scalaVersion := "2.11.8",
	version := "1.0.0",
	organization := "com.pharbers"
)

lazy val root = (project in file(".")).
	enablePlugins(PlayScala).
	settings(common: _*).
	settings(
		name := "TMIST",
		fork in run := true,
		javaOptions += "-Xmx2G"
	)

// lazy val root = (project in file(".")).
// 	enablePlugins(PlayScala).
// 	settings(
// 	    name := "TMIST",
// 	    ThisBuild / version := "1.0.0",
// 	    Compile / organization := "com.pharbers",
// 	    Compile / scalaVersion := "2.11.8",
// 	    Compile / scalacOptions += "-Xlint",
// 	    Compile / console / scalacOptions --= Seq("-Ywarn-unused", "-Ywarn-unused-import"),
// 	    Test / fork := true
//   )

routesGenerator := InjectedRoutesGenerator

resolvers += Resolver.mavenLocal

libraryDependencies += guice
libraryDependencies ++= Seq(
	"commons-httpclient" % "commons-httpclient" % "3.1",
	"org.mongodb" % "casbah_2.11" % "3.1.1",
	"com.easemob" % "rest-java-sdk" % "1.0.1",

	"com.pharbers" % "pharbers-module" % "0.1",
	"com.pharbers" % "pharbers-mongodb" % "0.1",
	"com.pharbers" % "pharbers-errorcode" % "0.1",
	"com.pharbers" % "pharbers-third" % "0.1",
	"com.pharbers" % "pharbers-security" % "0.1",
	"com.pharbers" % "pharbers-redis" % "0.1",
	"com.pharbers" % "pharbers-pattern" % "0.1",
	"com.pharbers" % "pharbers-max" % "0.1" exclude("com.fasterxml.jackson.core", "jackson-databind"),
	"com.pharbers" % "pharbers-spark" % "0.1" exclude("com.fasterxml.jackson.core", "jackson-databind"),

	"org.apache.commons" % "commons-email" % "1.4",
	"net.debasishg" % "redisclient_2.11" % "3.4",
	"org.apache.kafka" % "kafka_2.11" % "1.1.0" exclude("com.fasterxml.jackson.core", "jackson-databind"),
	"org.apache.kafka" % "kafka-streams" % "1.1.0" exclude("com.fasterxml.jackson.core", "jackson-databind"),
	"org.apache.avro" % "avro" % "1.7.6",
	"log4j" % "log4j" % "1.2.17",
	"commons-io" % "commons-io" % "2.4",
	"org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test,
	"org.specs2" % "specs2_2.11" % "3.7" % "test",

	"amplab" % "spark-indexedrdd" % "0.4.0", // kafka可回调后删除
	"org.apache.spark" % "spark-core_2.11" % "2.0.0", // kafka可回调后删除
	"org.apache.spark" % "spark-sql_2.11" % "2.0.0", // kafka可回调后删除
	"org.mongodb.spark" % "mongo-spark-connector_2.11" % "2.0.0", // kafka可回调后删除
	"com.fasterxml.jackson.core" % "jackson-core" % "2.6.0",// kafka可回调后删除
	"com.fasterxml.jackson.core" % "jackson-databind" % "2.6.0" // kafka可回调后删除

)
