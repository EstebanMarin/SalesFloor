package com.esteban.zhttpsalesfloor.domain

import zio._
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
import io.circe._, io.circe.generic.semiauto._
import scala.util.Try

final case class Item(
    by: String,
    descendants: Int,
    id: Int,
    Kids: List[Int],
    time: Double,
    title: String,
    `type`: String,
    url: String,
  )

object Item {
  implicit val itemDecoder: Decoder[HackerRankById]  = deriveDecoder[HackerRankById]
  implicit val itemEncoders: Encoder[HackerRankById] = deriveEncoder[HackerRankById]

  def codecService(bodys: List[String]): List[IO[ParsingFailure,Json]] =
    bodys.map(body => ZIO.fromEither(parse(body)))
}
