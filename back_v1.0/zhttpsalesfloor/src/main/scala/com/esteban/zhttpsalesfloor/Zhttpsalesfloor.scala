package com.esteban.zhttpsalesfloor

import zhttp.http._
import zhttp.service.Server
import zio._
import ZIOHttpsClient._
import zhttp.service.Client

object Zhttpsalesfloor extends App {
  val default = """{"greetings": "Hello World!"}"""
  def app(data: String): HttpApp[Any, Nothing] = Http.collect[Request] {
    case Method.GET -> !! / "text" => Response.text("Hello World!")
    case Method.GET -> !! / "json" => Response.json(data)
  }

  val greet: HttpApp[Any,Nothing] = Http.text("Esteban")
  // Run it like any simple app
  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = 
    (for {
     _ <- ZIO.succeed(println("Started application"))
    //  res <- ZIOHttpsClient.program
     _ <- ZIOHttpsClient.program
     _ <- Server.start(8090, app(default))
    } yield ()).exitCode
}
