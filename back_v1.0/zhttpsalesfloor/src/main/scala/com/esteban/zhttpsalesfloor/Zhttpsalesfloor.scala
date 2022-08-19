package com.esteban.zhttpsalesfloor

import zhttp.http._
import zhttp.service.Server
import zio._
import ZIOHttpsClient._
import zhttp.service.Client

object Zhttpsalesfloor extends App {
  def app(data: String): HttpApp[Any, Nothing] = Http.collect[Request] {
    case Method.GET -> !! => Response.json(data)
  }

  val greet: HttpApp[Any, Nothing]                               = Http.text("Esteban")
  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] =
    (for {
      _    <- ZIO.succeed(println("[SERVER] Started application"))
      json <- ZIOHttpsClient.program
      _    <- Server.start(8090, app(json))
    } yield ()).exitCode
}
