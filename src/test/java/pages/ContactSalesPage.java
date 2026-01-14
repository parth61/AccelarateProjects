package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class ContactSalesPage {

    WebDriver wd;
    WebDriverWait wait;
    public ContactSalesPage(WebDriver wd) {
        this.wd = wd;
        this.wait = new WebDriverWait(wd,Duration.ofSeconds(30));
        PageFactory.initElements(wd, this);
    }

    @FindBy(name = "FullName") WebElement fullName;

    @FindBy(name = "Email") WebElement email;

    @FindBy(name = "Contact") WebElement phone;

    @FindBy(name = "Country") WebElement country;

    @FindBy(name = "CompanyName") WebElement company;

    @FindBy(name = "JobTitle") WebElement jobTitle;

    @FindBy(name = "NoOfEmployees") WebElement employees;

    @FindBy(name = "Comment") WebElement comment;

    @FindBy(xpath = "//input[@value = 'Contact Sales']") WebElement submit;

    @FindBy(xpath = "//h1[contains(text(), 'Thank')]") WebElement successMessage;

    public void acceptCookiesIfPresent() {
        try {
            WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'Allow all')]")));

            acceptBtn.click();
            System.out.println("Cookies accepted");

        } catch (Exception e) {
            System.out.println("No cookies popup displayed");
        }
    }

    public  void fillForm(String name, String emailID, String phoneNo,
                          String companyName, String job, String commentText) {
        fullName.sendKeys(name);
        email.sendKeys(emailID);
        phone.sendKeys(phoneNo);
        company.sendKeys(companyName);
        jobTitle.sendKeys(job);
        comment.sendKeys(commentText);
    }

    public  void selectDropdown(WebElement element, String value) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();

        for (WebElement option : options){
            if (option.getText().equalsIgnoreCase(value)) {
                option.click();
                break;
            }
        }
    }

    public  void selectDropDownByValue(String countryName, String employeeNumber) {
        selectDropdown(country, countryName);
        selectDropdown(employees,employeeNumber);
    }

    public void clickCaptchaCheckbox() {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                    By.xpath("//iframe[@title='reCAPTCHA']")));

            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@class='recaptcha-checkbox-border']")));
            checkbox.click();

        }


    public void waitForCaptchaToBeSolved() {
        try{
            wait = new WebDriverWait(wd,Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[@aria-checked='true']")));
            System.out.println("Captcha is Solved");
            wd.switchTo().defaultContent();

        } catch (Exception e) {
            System.out.println("Captcha not solved in time");
        }
    }

    public  void submitForm() {
        submit.click();
    }

    public void isSubmissionSuccessful() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        System.out.println(wd.getTitle());

    }

}
