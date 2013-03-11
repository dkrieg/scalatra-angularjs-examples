package controllers

import org.scalatest.FunSpec
import org.scalatra.test.scalatest.ScalatraSuite

class TwitterControllerSpec extends ScalatraSuite with FunSpec {
  addServlet(classOf[TwitterController], "/*")

  val callback = "angular.callbacks._0"
  val path = "/search.json?callback=%s&q=%s" format (callback, "scalatra")

  describe("The TwitterController") {
    it("should respond to GET requests") {
      get(path) {
        status should equal (200)
      }
    }
    it("should respond as JSON") {
      get(path) {
        response.getContentType() should equal ("application/javascript;charset=UTF-8")
      }
    }
    it("should wrap the response in the JSONP callback") {
      get(path) {
        body should startWith (callback)
      }
    }
  }
}
