import Dependencies._

// give the user a nice default project!
ThisBuild / organization := "com.esteban"
ThisBuild / version      := "1.0.0"

lazy val root = (project in file("."))
  .enablePlugins(JavaAppPackaging)
  .settings(BuildHelper.stdSettings)
  .settings(
    name := "zhttpsalesfloor",
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework"),
    libraryDependencies ++= Seq(
      `zio-test`,
      `zio-test-sbt`,
      `zio-http`,
      `zio-http-test`,
      `zio-json`,
      `circe-core`,
      `circe-generic`,
      `circe-parser`,
    ),
  )
  .settings(
    Docker / version          := version.value,
    Compile / run / mainClass := Option("com.esteban.zhttpsalesfloor.Zhttpsalesfloor"),
  )

addCommandAlias("fmt", "scalafmt; Test / scalafmt; sFix;")
addCommandAlias("fmtCheck", "scalafmtCheck; Test / scalafmtCheck; sFixCheck")
addCommandAlias("sFix", "scalafix OrganizeImports; Test / scalafix OrganizeImports")
addCommandAlias(
  "sFixCheck",
  "scalafix --check OrganizeImports; Test / scalafix --check OrganizeImports",
)
