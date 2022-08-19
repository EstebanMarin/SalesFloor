import sbt._

object Dependencies {
  val ZioVersion   = "1.0.13"
  val ZHTTPVersion = "1.0.0.0-RC24"
  val CirceVersion = "0.14.1"

  val `zio-http`      = "io.d11" %% "zhttp" % ZHTTPVersion
  val `zio-http-test` = "io.d11" %% "zhttp" % ZHTTPVersion % Test

  val `zio-test`     = "dev.zio" %% "zio-test"     % ZioVersion % Test
  val `zio-test-sbt` = "dev.zio" %% "zio-test-sbt" % ZioVersion % Test
  val `zio-json`     = "dev.zio" %% "zio-json" % "0.1.5"

  val `circe-core`    = "io.circe" %% "circe-core"    % CirceVersion
  val `circe-generic` = "io.circe" %% "circe-generic" % CirceVersion
  val `circe-parser`  = "io.circe" %% "circe-parser"  % CirceVersion
}
