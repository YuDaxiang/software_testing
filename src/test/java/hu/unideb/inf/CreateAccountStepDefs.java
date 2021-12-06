package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;




import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class CreateAccountStepDefs extends AbstractStepDefs {

    @And("the Sign In link is clicked")
    public void theSignInLinkIsClicked() {
        homePage.clickSignInLink();
    }

    @When("the Sign In button is clicked")
    public void theSignInButtonIsClicked() {
        homePage.clickSignInButton();
    }

    @Given("the {string} is filled with {string}")
    public void theFieldIsFilledWithParameter(String field, String parameter) {
        homePage.fillField(field, parameter);
    }

    @When("the Create Account button is clicked")
    public void theCreateAccountButtonIsClicked() {
        homePage.clickCreateAccountButton();
    }

    @Then("the {string} error message is shown")
    public void theMsgErrorMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getRegisterError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }

    @Then("the CreateAccount{string} Button is shown")
    public void theMyAccountIsShown(String msg) {
        Optional<String> errorMessage = homePage.getCreateAccountMessage();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }

}
