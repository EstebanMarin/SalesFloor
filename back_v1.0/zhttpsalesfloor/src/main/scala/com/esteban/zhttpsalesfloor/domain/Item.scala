package com.esteban.zhttpsalesfloor.domain

import zio._
import zio.json._

final case class Item(
    by: String,
    descendants: Option[Int],
    id: Option[Int],
    Kids: Option[List[Int]],
    time: Option[Double],
    title: String,
    `type`: Option[String],
    url: Option[String],
  )

object Item {
  implicit val decoder: JsonDecoder[Item] =
    DeriveJsonDecoder.gen[Item]

  implicit val encoder: JsonEncoder[Item] =
    DeriveJsonEncoder.gen[Item]

  def decoderService(res: List[String]) = ZIO.collectAllPar(
    res.map(_.fromJson[Item] match {
      case Left(e)  => ZIO.fail(e)
      case Right(v) => ZIO.succeed(v)
    }),
  )
  
  def itemsEncoder(items: List[Item]): String = items.toJson

}
