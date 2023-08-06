import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import pageOblects.PageObject;
import pageOblects.PageObject.Gender;

import java.util.Random;

import static java.util.Optional.empty;

public class TestClass {
    @Test
    void startWebDriver() {
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(empty(), empty(), empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of("*google*", "*ad.plus*")));

        driver.get("https://demoqa.com/automation-practice-form");

        PageObject page = new PageObject(driver);
        page.setFirstName("Dale");
        page.setLastName("Cooper");
        page.setUserEmail("d.cooper@fbi.gov");
//        page.setGender(Gender.MALE);
        page.setGender(Gender.FEMALE);
        page.setMobileNumber(String.valueOf(new Random().nextLong(9_000_000_000L, 10_000_000_000L)));
    }
}
