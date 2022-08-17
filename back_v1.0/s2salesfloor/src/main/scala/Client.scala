import sttp.client3.quick._
import sttp.client3.circe._

import io.circe.generic.auto._
import io.circe
import sttp.client3.{
  Response ,
  ResponseException 
}
import sttp.client3.{Identity => STTPIdentity}
final case class Client()
case class HackerRankById(id: Int)
case class Item(
    by: String,
    descendants: Int,
    id: Int,
    Kids: List[Int],
    time: Double,
    title: String,
    `type`: String,
    url: String
)
object Client {
  type TopStoriesIds = List[HackerRankById]
  val query = "language:scala"
  val sort: Option[String] = Some("stars")
  val getTopByID = basicRequest
    .get(uri"https://hacker-news.firebaseio.com/v0/topstories.json")
    .response(asJson[TopStoriesIds])

  def getStory(hId: HackerRankById) = basicRequest
    .get(uri"https://hacker-news.firebaseio.com/v0/item/${hId.id}.json")
    .response(asJson[Item])

  val getTopbyID = getTopByID.send(backend)
  getTopbyID.body match {
    case Left(error) => println(s"Error when executing request: $error")
    case Right(data: TopStoriesIds) =>
      println(s"[RESPONSE]  => \n ${data}")
  }

  def getItems(hId: HackerRankById) = getStory(hId).send(backend).body match {
    case Left(error) => None
    case Right(data: Item) =>
      println(s"[RESPONSE]  => \n ${data}")
      Some(data)
  }
  def mapOverID(data: TopStoriesIds): List[Option[Item]] =
    data.map(getItems).filter(_.nonEmpty)

}
