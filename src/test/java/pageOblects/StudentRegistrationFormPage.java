package pageOblects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StudentRegistrationFormPage {
    WebDriver driver;

    public StudentRegistrationFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;
    @FindBy(css = "#lastName")
    private WebElement lastName;
    @FindBy(id = "userEmail")
    private WebElement userEmail;
    @FindBy(xpath = "//input[@value='Male']/..")
    private WebElement genderMale;
    @FindBy(css = "div#genterWrapper > div > div:has(input[value='Female'])")
    private WebElement genderFemale;
    @FindBy(xpath = "//input[@value='Other']")
    private WebElement genderOther;
    @FindBy(id = "userNumber")
    private WebElement mobileNumber;
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirth;
    @FindBy(css = ".react-datepicker__month-select")
    private WebElement monthSelector;
    @FindBy(css = ".react-datepicker__year-select")
    private WebElement yearSelector;
    @FindBy(css = "div.react-datepicker__day:not(.react-datepicker__day--outside-month)")
    private List<WebElement> daysElements;
    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;
    @FindBy(id = "uploadPicture")
    private WebElement uploadPicture;
    @FindBy(id = "currentAddress")
    private WebElement currentAddress;
    @FindBy(id = "state")
    private WebElement state;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "submit")
    private WebElement submit;


    public void setFirstName(String name) {
        firstName.sendKeys(name);
    }

    public void setLastName(String surname) {
        lastName.sendKeys(surname);
    }

    public void setUserEmail(String email) {
        userEmail.sendKeys(email);
    }


    public enum Gender {
        MALE, FEMALE, OTHER;
    }

    public void setGender(Gender gender) {
        switch (gender) {
            case MALE -> genderMale.click();
            case FEMALE -> genderFemale.click();
            case OTHER -> genderOther.click();
        }
    }

    public void setMobileNumber(String number) {
        mobileNumber.sendKeys(number);
    }

    public void setDateOfBirth(int day, int month, int year) {
        dateOfBirth.click();
        Select yearSelect = new Select(yearSelector);
        yearSelect.selectByValue(String.valueOf(year));
        Select monthSelect = new Select(monthSelector);
        monthSelect.selectByValue(String.valueOf(month - 1));

        String dayClass = String.format("react-datepicker__day--%03d", day);
        WebElement dayElem = daysElements.stream()
                .filter(e -> e.getAttribute("class").contains(dayClass))
                .findFirst().get();
        dayElem.click();
    }

    public void setSubjects(String subject) {
        subjectsInput.sendKeys(subject);
        subjectsInput.sendKeys(Keys.RETURN);
    }

    public void setUploadPicture(String pictureName) {
        Path resourceDirectory = Paths.get("src", "test", "resources", pictureName);
        uploadPicture.sendKeys(resourceDirectory.toFile().getAbsolutePath());
    }

    public void setCurrentAddress(String address) {
        currentAddress.sendKeys(address);
    }

    public void setState(String selectedState) {
        state.click();
        driver.findElement(By.xpath("//div[text()='" + selectedState + "']")).click();
    }

    public void setCity(String selectedCity) {
        city.click();
        driver.findElement(By.xpath("//div[text()='" + selectedCity + "']")).click();
    }

    public void clickSubmit() {
        submit.click();
    }
}
