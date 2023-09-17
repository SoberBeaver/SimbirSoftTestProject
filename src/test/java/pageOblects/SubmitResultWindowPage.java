package pageOblects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubmitResultWindowPage {
    WebDriver driver;

    public SubmitResultWindowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement title;
    @FindBy(xpath = "//td[text()='Student Name']/following-sibling::td")
    private WebElement studentNameValue;
    @FindBy(xpath = "//td[text()='Student Email']/following-sibling::td")
    private WebElement studentEmailValue;
    @FindBy(xpath = "//td[text()='Gender']/following-sibling::td")
    private WebElement genderValue;
    @FindBy(xpath = "//td[text()='Mobile']/following-sibling::td")
    private WebElement mobileValue;
    @FindBy(xpath = "//td[text()='Date of Birth']/following-sibling::td")
    private WebElement dateOfBirthValue;
    @FindBy(xpath = "//td[text()='Subjects']/following-sibling::td")
    private WebElement subjectValue;
    @FindBy(xpath = "//td[text()='Hobbies']/following-sibling::td")
    private WebElement hobbiesValue;
    @FindBy(xpath = "//td[text()='Picture']/following-sibling::td")
    private WebElement pictureValue;
    @FindBy(xpath = "//td[text()='Address']/following-sibling::td")
    private WebElement addressValue;
    @FindBy(xpath = "//td[text()='State and City']/following-sibling::td")
    private WebElement stateAndCityValue;

    public void assertTitleIsEqual(String expectedTitle) {
        assertEquals(expectedTitle, title.getText());
    }
    public void assertStudentNameIsEqual(String expectedName) {
        assertEquals(expectedName, studentNameValue.getText());
    }
    public void assertStudentEmailIsEqual(String expectedEmail) {
        assertEquals(expectedEmail, studentEmailValue.getText());
    }
    public void assertGenderIs(String expectedGender) {
        assertEquals(expectedGender, genderValue.getText().toUpperCase());
    }
    public void assertMobileIs(String expectedMobile) {
        assertEquals(expectedMobile, mobileValue.getText());
    }
    public void assertDateOfBirthIs(int day, int month, int year) {
        String datePattern = "dd MMMM,yyyy";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(datePattern).withLocale(Locale.ENGLISH);
        String expectedDateOfBirth = dateFormatter.format(LocalDate.of(year, month, day));
        assertEquals(expectedDateOfBirth, dateOfBirthValue.getText());
    }
    public void assertSubjectIs(String expectedSubject) {
        assertEquals(expectedSubject, subjectValue.getText());
    }
    public void assertHobbiesIsEmpty() {
        assertEquals("", hobbiesValue.getText());
    }
    public void assertPictureIs(String expectedPicture) {
        assertEquals(expectedPicture, pictureValue.getText());
    }
    public void assertAddressIs(String expectedAddress) {
        assertEquals(expectedAddress, addressValue.getText());
    }
    public void stateAndCityValue(String expectedStateAndCity) {
        assertEquals(expectedStateAndCity, stateAndCityValue.getText());
    }

}
