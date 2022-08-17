package com.estebanmarin.zioserver

import zhttp.http._
import zhttp.service.Server
import zio._

object Zioserver extends App {
  val defaultValue = """{"greetings": "Hello World!"}"""

  val app: HttpApp[Any, Nothing] = Http.collect[Request] {
    case Method.GET -> !! / "json" => 
      // Response.json(SttpClient.getTopbyID.toString())
      Response.text(SttpClient.getTopbyID.toString())
  }

  // Run it like any simple app
  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] =
    Server.start(8090, app).exitCode
}
