name := "id2221_project"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.2.1",
  "org.apache.spark" %% "spark-sql" % "2.2.1",
  "org.twitter4j" % "twitter4j-core" % "3.0.6",
  "org.apache.spark" % "spark-streaming_2.11" % "2.2.1",
  "org.twitter4j" % "twitter4j-stream" % "4.0.2-SNAPSHOT"
)
