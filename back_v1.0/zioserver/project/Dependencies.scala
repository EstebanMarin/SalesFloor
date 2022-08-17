import sbt._

object Dependencies {
  val ZioVersion   = "1.0.13"
  val ZHTTPVersion = "1.0.0.0-RC24"
  val sttpClientVersion = "3.7.4"
  val circeVersion = "0.14.1"

  val `zio-http`      = "io.d11" %% "zhttp" % ZHTTPVersion
  val `zio-http-test` = "io.d11" %% "zhttp" % ZHTTPVersion % Test

  val `zio-test`     = "dev.zio" %% "zio-test"     % ZioVersion % Test
  val `zio-test-sbt` = "dev.zio" %% "zio-test-sbt" % ZioVersion % Test

  val `stt-client-core` = "com.softwaremill.sttp.client3" %% "core"  % sttpClientVersion
  val `stt-client-circe` = "com.softwaremill.sttp.client3" %% "circe" % sttpClientVersion

  val `circe-core` = "io.circe" %% "circe-core" % circeVersion
  val `circe-generic` = "io.circe" %% "circe-generic" % circeVersion
  val `circe-parse` = "io.circe" %% "circe-parser" % circeVersion

      
}
