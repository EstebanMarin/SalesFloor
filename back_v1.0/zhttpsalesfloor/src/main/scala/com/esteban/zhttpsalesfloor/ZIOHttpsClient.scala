package com.esteban.zhttpsalesfloor

import io.netty.handler.ssl.SslContextBuilder
import zhttp.http.Headers
import zhttp.service.client.ClientSSLHandler.ClientSSLOptions
import zhttp.service.{ChannelFactory, Client, EventLoopGroup}
import zio._
import com.esteban.zhttpsalesfloor.domain.HackerRankById._
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
    _                              <- console.putStrLn(s"Hello")
    resbyid: Client.ClientResponse <- Client.request(url)
    stringList                     <- resbyid.bodyAsString
    listbyID   = stringList.filter(_ != '[').filter(_ != ']').split(',').slice(0, 30).toList
    parEffects =
      listbyID.map(getItemService)
    response: List[String] <- ZIO.collectAllPar(parEffects)
    _                      <- console.putStrLn(s"${response.head}")
  } yield resbyid).provideCustomLayer(env)
}
