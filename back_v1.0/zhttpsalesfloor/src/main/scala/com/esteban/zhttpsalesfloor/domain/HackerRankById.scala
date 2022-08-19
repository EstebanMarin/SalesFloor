package com.esteban.zhttpsalesfloor.domain

import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
import io.circe._, io.circe.generic.semiauto._

final case class HackerRankById(id: Int)
object HackerRankById {
  implicit val hDecoder: Decoder[HackerRankById]  = deriveDecoder[HackerRankById]
  implicit val hEncoders: Encoder[HackerRankById] = deriveEncoder[HackerRankById]
}
