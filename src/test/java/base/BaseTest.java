package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    protected WebDriver wd;

    @BeforeClass
    public void setup() {
        wd = new EdgeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wd.get("https://www.orangehrm.com/en/contact-sales");
        wd.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        wd.quit();
    }

}
