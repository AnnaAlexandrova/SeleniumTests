import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTestCardNumber {
    private WebDriver webDriver;
    private CardNumberPage cardNumberPage;

    @Before
    public void setUp() {
        String chromeDriverPath = "C:\\Users\\fytyr\\Infra\\WebDrivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        webDriver = new ChromeDriver();

        cardNumberPage = new CardNumberPage(webDriver);
        cardNumberPage.gotoCardNumberPage();
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test
    public void cardNumberPositiveTest() {
        cardNumberPage.enterCardNumber("5533553355335533");

        Assert.assertTrue(cardNumberPage.getFormButton().isEnabled());
    }

    @Test
    public void cardNumberInputStringTest() {
        cardNumberPage.enterCardNumber("qqqq");

        Assert.assertFalse(cardNumberPage.getFormButton().isEnabled());
    }

    @Test
    public void cardNumberInputShortNumberTest() {
        cardNumberPage.enterCardNumber("1234567");

        Assert.assertFalse(cardNumberPage.getFormButton().isEnabled());
    }
}
