enablePlugins(UniversalPlugin)
enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

ThisBuild / scalaVersion := "2.13.8"
organization := "com.esteban"
version := "1.0"

val circeVersion = "0.14.1"

lazy val hello = (project in file("."))
  .settings(
    name := "scala2",
    name := "S2salesfloor",
    libraryDependencies += "com.softwaremill.sttp.client3" %% "core" % "3.7.4",
    libraryDependencies += "com.softwaremill.sttp.client3" %% "circe" % "3.7.4",
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core",
      "io.circe" %% "circe-generic",
      "io.circe" %% "circe-parser"
    ).map(_ % circeVersion)
  )

// lazy val dependencies = Seq(
//   libraryDependencies ++= Seq(
//     // main dependencies
//   ),
//   libraryDependencies ++= Seq(
//     org.scalatest.scalatest,
//     org.scalatestplus.`scalacheck-1-16`,
//   ).map(_ % Test),
// )
