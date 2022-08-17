package com.estebanmarin.htt4ssalesfloor

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  def run(args: List[String]) =
    Htt4ssalesfloorServer.stream[IO].compile.drain.as(ExitCode.Success)
}
