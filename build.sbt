name := "id2221_project"

version := "0.1"

scalaVersion := "2.11.8"

organization := "se.id2221"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.2.1",
  "org.apache.spark" %% "spark-streaming" % "2.2.1",
  "org.apache.bahir" %% "spark-streaming-twitter" % "2.2.1"
)

libraryDependencies += "edu.stanford.nlp" % "stanford-corenlp" %
  "3.5.2" artifacts (Artifact("stanford-corenlp", "models"), Artifact("stanford-corenlp"))
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"

