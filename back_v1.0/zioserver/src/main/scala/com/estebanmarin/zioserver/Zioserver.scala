package com.estebanmarin.zioserver

import zhttp.http._
import zhttp.service.Server
import zio._
import io.circe
import sttp.client3
import sttp.client3.ResponseException
import sttp.client3.Identity

object Zioserver extends App {
  val defaultValue = """{"greetings": "Hello World!"}"""

  val app: HttpApp[Any, Nothing] = Http.collect[Request] {
    case Method.GET -> !! / "json" =>
      // Response.json(SttpClient.getTopbyID.toString())
      Response.text(defaultValue)
  }

  // Run it like any simple app
  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = (for {
    _ <- ZIO.succeed(println(s"Starting server"))
    _ <- Server.start(8090, app)
  } yield ()).exitCode
  // Server.s.exitCodetart(8090, app).exitCode
}
