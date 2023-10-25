ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "scalaTraining",
    idePackagePrefix := Some("com.training")

)
libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.3.0-SNAP4" % Test
libraryDependencies += "com.h2database" % "h2" % "2.2.224" //% Test

// h2