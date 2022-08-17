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
    libraryDependencies += "dev.zio" %% "zio" % "2.0.0",
    libraryDependencies += "io.d11" %% "zhttp"      % "2.0.0-RC10",
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core",
      "io.circe" %% "circe-generic",
      "io.circe" %% "circe-parser"
    ).map(_ % circeVersion)
  )