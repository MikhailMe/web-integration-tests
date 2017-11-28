package core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestBase {
    private static final String BASE_URL = "https://ok.ru/";
    private static final String DELIMETER = "/";
    private StringBuffer verificationErrors;
    protected WebDriver driver;

    {
        verificationErrors = new StringBuffer();
    }

    @Before
    public void setUp() throws Exception {
        init();
    }

    @After
    public void tearDown() throws Exception {
        stop();
    }

    private void init() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1600, 1200));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL + DELIMETER);
    }

    private void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
