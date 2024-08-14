import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.tkbank.exercise.common.Config;
import org.tkbank.exercise.common.Driver;
import org.tkbank.exercise.pages.BasePage;

abstract public class BaseTest {
    private static WebDriver driver = Driver.getInstance(Config.BROWSER);
    @BeforeAll
    public static void setUp() {
        BasePage.setDriver(driver);
    }

    @AfterAll
    public static void tearDown() {
//        driver.close();
//        driver.quit();
    }
}
