package com.esteban.zhttpsalesfloor

import io.netty.handler.ssl.SslContextBuilder
import zhttp.http.Headers
import zhttp.service.client.ClientSSLHandler.ClientSSLOptions
import zhttp.service.{ChannelFactory, Client, EventLoopGroup}
import zio._
import com.esteban.zhttpsalesfloor.domain.HackerRankById._
import com.esteban.zhttpsalesfloor.domain.Item
import com.esteban.zhttpsalesfloor.domain.Item._

object ZIOHttpsClient {
  val env = ChannelFactory.auto ++ EventLoopGroup.auto()
  val url = "https://hacker-news.firebaseio.com/v0/topstories.json"

  def getItemService(
      id: String,
    ): ZIO[EventLoopGroup with ChannelFactory, Throwable, String] = for {
    res: Client.ClientResponse <- Client.request(
      s"https://hacker-news.firebaseio.com/v0/item/$id.json",
    )
    bodyString                 <- res.bodyAsString
  } yield bodyString


  val program = (for {
    _                              <- console.putStrLn(s"[STARTING CLIENT]")
    resbyid: Client.ClientResponse <- Client.request(url)
    stringList                     <- resbyid.bodyAsString
    listbyID   = stringList.filter(_ != '[').filter(_ != ']').split(',').slice(0, 30).toList
    parEffects =
      listbyID.map(getItemService)
    response: List[String] <- ZIO.collectAllPar(parEffects)
    items <- Item.decoderService(response)
    json: String = Item.itemsEncoder(items)
  } yield json).provideCustomLayer(env)
}
