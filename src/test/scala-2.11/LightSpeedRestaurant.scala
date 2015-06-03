
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.scalatest.time.{Seconds, Span}

/**
 * Created by sushi on 15-06-02.
 *
 * A lot more asserts and check
 * statments should be added to verify the various stages.
 * Especially when the user finally get created.
 * The
 *
 */
class LightSpeedRestaurant extends UnitSpec {

  implicit val webDriver: WebDriver = new FirefoxDriver()
  // Headless webdriver defined below.
  //  implicit val webDriver: WebDriver = new HtmlUnitDriver

  // After all the tests are completed close the browser
  override def afterAll: Unit = {
    close
  }


  "User " should "start on the main Light Speed Page and reach the Start for Free Page" in {

    goTo("http://www.lightspeedpos.com")
    pageTitle should be("POS system | Point of sale software | Lightspeed POS")

    clickOn(linkText("For Restaurants"))
    clickOn(linkText("Start For Free"))
  }

  "it" should "allow a user to create a free account" in {
    goTo("http://www.lightspeedpos.com/restaurant/register/")

    clickOn("company")
    textField("company").value = "sushi_company"
    clickOn("firstname")
    textField("firstname").value = "sushi_first_name"
    clickOn("lastname")
    textField("lastname").value = "sushi_first_name"

    clickOn("country")
    singleSel("country").value = "Belgium"

    clickOn("phone")
    textField("phone").value = "514-823-2547"

    clickOn("emailAddress")
    emailField("emailAddress").value = "sushi@gmail.com"

    clickOn("password1")
    pwdField("password1").value = "sushi123456"

    // the wait has been added simple for you to be able
    // to see all the values entered.
    implicitlyWait(Span(5, Seconds))

    // unchecking the below clickOn("submit) will submit the form
    // and will complete succesful sign up on new
    // free user
    //   clickOn("submit")

  }

}
