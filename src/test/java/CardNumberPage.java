import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class CardNumberPage {
    private WebDriver webDriver;

    @FindBy(id = "cardNumber")
    private WebElement cardNumberField;

    @FindBy(xpath = "//*[@id=\"signUpForm\"]/button")
    private WebElement formButton;

    CardNumberPage(WebDriver driver) {
        webDriver = driver;

        PageFactory.initElements(webDriver, this);
    }

    void gotoCardNumberPage() {
        webDriver.get("https://online.sberbank.ru/");
        WebElement getRegistration = webDriver.findElement(
                By.xpath("//*[@id=\"application\"]/div/div/div/div[1]/div/div[1]/div/div/div/div[2]/div[3]/a"));
        getRegistration.click();
    }

    void enterCardNumber(String cardNumber) {
        cardNumberField.sendKeys(cardNumber);
        formButton.click();
    }

    WebElement getFormButton() {
        return formButton;
    }
}
