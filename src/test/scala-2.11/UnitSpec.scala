/**
 * Created by sushi on 15-06-02.
 */

import org.scalatest._
import org.scalatest.selenium.WebBrowser

abstract class UnitSpec extends FlatSpec with Matchers with WebBrowser with GivenWhenThen with BeforeAndAfterAll
