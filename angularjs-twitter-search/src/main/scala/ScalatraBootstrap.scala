import controllers._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context mount (new ViewController, "/*")
    context mount (new TwitterController, "/twitter")
  }
}