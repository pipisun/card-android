import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import static org.example.Main.getRefImage;


public class CardForAndroidTest {
    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException, URISyntaxException {
        DesiredCapabilities capabilities = getDesiredCapabilities();
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(180));

    }

    private static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("appPackage", "com.tetherstudios.solitaire.klondike");
        capabilities.setCapability("appActivity", "com.skillz.activity.UnityGameActivity");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("newCommandTimeout", 3000);
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("forceAppLaunch", true);
        return capabilities;
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testFindingAnElement() throws Exception {
        // Play Now
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
//        System.out.println(wait);
//
        By game_view = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View[2]");
        WebElement landing_page = driver.findElement(game_view);
////        System.out.println(landing_page.isEnabled());
        wait.until(ExpectedConditions.invisibilityOf(landing_page));
        Thread.sleep(30000);
//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        Point tapPoint = new Point(510, 2010);
//        Sequence tap = new Sequence(finger, 1);
//        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(Arrays.asList(tap));
//
//        //Hit Practice
//        By practice_icon = By.xpath("//div[contains(@class,\"plus\") and .=\"-\"]");
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(practice_icon)));
        String encodedImg = getRefImage("playnow.png");
        driver.findElement(AppiumBy.image(encodedImg)).click();

    }
}
