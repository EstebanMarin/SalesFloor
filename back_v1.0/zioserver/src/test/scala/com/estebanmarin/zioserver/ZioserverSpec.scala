package com.estebanmarin.zioserver

import zio.test._
import zio.test.Assertion._
import zhttp.http._

object ZioserverSpec extends DefaultRunnableSpec {
  override def spec: ZSpec[Environment, Failure] = suite("""ZioserverSpec""")(
    testM("200 ok") {
      checkAllM(Gen.fromIterable(List("text", "json"))) { uri =>
        val request = Request(Method.GET, URL(!! / uri))
        assertM(Zioserver.app(request).map(_.status))(equalTo(Status.OK))
      }
    },
  )
}
