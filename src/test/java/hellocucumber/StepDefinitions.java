package hellocucumber;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


public class StepDefinitions {


    @Given("Open google page")
    public void today_is_sunday() {
        Selenide.open("https://www.google.com/search?q=car");

    }
    @When("Click link with image")
    public void i_ask_whether_it_s_friday_yet() {
        Selenide.$(By.cssSelector(".bmaJhd")).click();
    }
    @Then("Title contain  {string}")
    public void i_should_be_told_nope_mvn_test(String string) {
        Assert.assertTrue(Selenide.title().contains(string));


    }

}
