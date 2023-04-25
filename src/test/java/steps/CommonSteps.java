package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CommonSteps {
    WebDriver driver;
    By emailField = By.cssSelector("[placeholder=\"Email\"]");
    By passwordField = By.cssSelector("[placeholder=\"Password\"]");
    By loginButton = By.xpath("//*[@type=\"submit\"]");
    By contactsTable = By.id("contacts-list");
    By loginForm = By.id("login-form");
    By userRegistrationLink = By.cssSelector("[href=\"/user/registration\"]");
    By errorMessageBlock = By.id("error-message");
    By confirmPasswordField = By.cssSelector("[ng-reflect-name=\"confirm_password\"]");
//    @Given("Login")
//    public void login(){
//        navigateToLoginPage();
//        fillLoginForm();
//        clickOnLoginButton();
//        checkDisplayedContactPage();
//    }
    @Given("Navigate to Login Page")
    public void navigateToLoginPage() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://phonebook.telran-edu.de:8080/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @When("Fill fields valid data")
    public void fillLoginForm() {
        fillField(emailField, "test@gmail.com");
        fillField(passwordField, "test@gmail.com");
    }
    @And("Click on Login button")
    public void clickOnLoginButton() {
        click(loginButton);
    }
    @Then("Check displayed Contact page")
    public void checkDisplayedContactPage() {
        driver.findElement(contactsTable).isDisplayed();
    }


//    Registration
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    @When("Click on registration link")
    public void clickOnRegistrationLink(){
        click(userRegistrationLink);
    }
    @And("Fill registration form")
    public void fillRegistrationForm(){
      fillField(emailField, email);
      fillField(passwordField, password);
      fillField(confirmPasswordField, password);
    }
    @And("Click on SignUp button")
    public void clickOnSigUpButton(){
      click(loginButton);
    }
    @Then("Check displayed message noErrorMsg")
    public void checkDisplayMessage() {
        checkItemText(errorMessageBlock,"noErrorMsg");
    }
    public void checkItemText(By locator, String expectedText) {
        String actualText = driver.findElement(locator).getText();
        Assert.assertEquals(actualText, expectedText);
    }
    public void fillField(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
    public void click(By locator) {
        driver.findElement(locator).click();
    }
    @After
    public void quit(){
        driver.quit();
    }
}
