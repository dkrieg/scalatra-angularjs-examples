package controllers

import org.scalatra.ScalatraServlet
import org.scalatra.util.RicherString._

class TwitterController extends ScalatraServlet {

  get("/search.json") {
    contentType = "application/javascript"

    import dispatch._
    val path = "http://search.twitter.com/search.json?callback=%s&q=%s" format (params("callback"), params("q"))
    val svc = dispatch.url(path urlEncode)
    val tweets = Http(svc OK as.String)
    tweets()
  }
}


