import com.google.common.collect.ImmutableList;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import pageOblects.StudentRegistrationFormPage;
import pageOblects.StudentRegistrationFormPage.Gender;
import pageOblects.SubmitResultWindowPage;

import java.util.Random;

import static java.util.Optional.empty;

public class TestClass {
    static ChromeDriver driver;

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        Dimension dimension = new Dimension(1920, 1080);
        driver.manage().window().setSize(dimension);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(empty(), empty(), empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of("*google*", "*ad.plus*")));

        driver.get("https://demoqa.com/automation-practice-form");
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    @Feature("Submit Student Registration Form")
    void startWebDriver() {
        String firstName = "Dale";
        String lastName = "Cooper";
        String email = "d.cooper@fbi.gov";
        Gender gender = Gender.FEMALE;
        String mobileNumber = String.valueOf(new Random().nextLong(9_000_000_000L, 10_000_000_000L));
        int day = 19;
        int month = 4;
        int year = 1954;
        String subject = "Hindi";
        String picture = "Agentdalecooper.jpg";
        String currentAddress = "Twin Peaks";
        String state = "Haryana";
        String city = "Karnal";

        StudentRegistrationFormPage page = new StudentRegistrationFormPage(driver);
        page.setFirstName(firstName);
        page.setLastName(lastName);
        page.setUserEmail(email);
        page.setGender(gender);
        page.setMobileNumber(mobileNumber);
        page.setDateOfBirth(day, month, year);
        page.setSubjects(subject);
        page.setUploadPicture(picture);
        page.setCurrentAddress(currentAddress);
        page.setState(state);
        page.setCity(city);
        page.clickSubmit();

        SubmitResultWindowPage srWindow = new SubmitResultWindowPage(driver);
        srWindow.assertTitleIsEqual("Thanks for submitting the form");
        srWindow.assertStudentNameIsEqual(String.format("%s %s", firstName, lastName));
        srWindow.assertStudentEmailIsEqual(email);
        srWindow.assertGenderIs(gender.toString());
        srWindow.assertMobileIs(mobileNumber);
        srWindow.assertDateOfBirthIs(day, month, year);
        srWindow.assertSubjectIs(subject);
        srWindow.assertHobbiesIsEmpty();
        srWindow.assertPictureIs(picture);
        srWindow.assertAddressIs(currentAddress);
        srWindow.stateAndCityValue(String.format("%s %s", state, city));
    }
}
