package com.estebanmarin.zioserver.domain

object Domain {
  case class HackerRankById(id: Int)
  case class Item(
      by: String,
      descendants: Int,
      id: Int,
      Kids: List[Int],
      time: Double,
      title: String,
      `type`: String,
      url: String,
    )
}
