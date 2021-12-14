package hu.unideb.inf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Optional;

public class HomePage {

    private static final String PAGE_URL = "http://automationpractice.com/";
    private static final By REGISTER_ERROR = By.xpath("//*[@id=\"create_account_error\"]/ol/li");    private static final By LOGIN_ERROR = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");
    private static final By CONTACT_ERROR = By.cssSelector("#center_column > div > ol > li");
    private static final  By Create_Account_ERROR = By.id("create_account_error");
    private static final By PrintedDress = By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/h5/a");
    private static final By SEARCH_ERROR = By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/p");


    @FindBy(className = "login")//通过指定name属性，可以将signInLink转换成当前页面的一个WebElement对象
    private WebElement signInLink;//定义变量

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(id = "contact-link")
    private WebElement contactUsLink;

    @FindBy(id = "submitMessage")
    private WebElement sendButton;

    @FindBy(id="SubmitCreate")
    private WebElement CreateAccountButton;

    @FindBy(id="submitAccount")
    private WebElement registerButton;

    @FindBy(name ="submit_search")
    private WebElement searchButton;

    public WebElement getSearchButton() {
        return searchButton;
    }

    public static By getPrintedDress() {
        return PrintedDress;
    }

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);//get一下url
        PageFactory.initElements(driver, this);
    }

    public void clickSignInLink() {
        signInLink.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickCreateAccountButton(){
        CreateAccountButton.click();
    }

    public void clickRegisterButton(){
        registerButton.click();
    }

    public Optional<String> getRegisterError() {
        return getErrorMessage(REGISTER_ERROR);
    }
    public  Optional<String> getCreateAccountError(){
        return getCreateAccountMessage();
    }
    public Optional<String> getLoginError() {
        return getErrorMessage(LOGIN_ERROR);
    }

    public Optional<String> getContactError() {
        return getErrorMessage(CONTACT_ERROR);
    }

    public Optional<String> getSearchError() {
        return getErrorMessage(SEARCH_ERROR);
    }

    public void fillField(String field, String value) {
        getField(By.id(field)).sendKeys(value);
    }

    public WebElement getField(By locator) {
        return driver.findElement(locator);
    }

    public WebElement getSignInLink() {
        return signInLink;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getContactUsLink() {
        return contactUsLink;
    }

    public WebElement getSendButton() {
        return sendButton;
    }

    public Optional<String> getCreateAccountMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitAccount")));
        WebElement element = driver.findElement(By.id("submitAccount"));
        return Optional.of(element.getText());
    }

    public Optional<String> getregisterError(){
        return getErrorMessage(REGISTER_ERROR);
    }

    public void clicksearchButton(){searchButton.click();}

    public void logout () {
        WebElement element = driver.findElement(By.className("logout"));
        element.click();
    }

    public Optional<String> getMyAccountMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("info-account")));
        WebElement element = driver.findElement(By.className("info-account"));
        return Optional.of(element.getText());
    }

    private Optional<String> getErrorMessage(By errorLocator) {
        Optional<WebElement> error = getError(errorLocator);
        if (error.isPresent()) {
            WebElement errorElement = error.get();
            return Optional.of(errorElement.getText());
        } else {
            return Optional.empty();
        }
    }

    private Optional<WebElement> getError(By errorLocator) {
        List<WebElement> elements = driver.findElements(errorLocator);
        if (elements.size() > 0) {
            return Optional.of(elements.get(0));
        } else {
            return Optional.empty();
        }
    }
}
