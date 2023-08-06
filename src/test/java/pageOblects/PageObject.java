package pageOblects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
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

    public void setDateOfBirth() {
        dateOfBirth.click();

    }

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
        MALE, FEMALE, OTHER
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

    WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
