package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ContactSalesPage {

    WebDriver wd;
    public ContactSalesPage(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    @FindBy(name = "FullName")
    WebElement fullName;

    @FindBy(name = "Email")
    WebElement email;

    @FindBy(name = "Contact")
    WebElement phone;

    @FindBy(name = "Country")
    WebElement country;

    @FindBy(name = "CompanyName")
    WebElement company;

    @FindBy(name = "JobTitle")
    WebElement jobTitle;

    @FindBy(name = "NoOfEmployees")
    WebElement employees;

    @FindBy(name = "Comment")
    WebElement comment;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    WebElement captcha;

    @FindBy(xpath = "//input[@value = 'Contact Sales']")
    WebElement submit;

    public  void fillForm(String name, String emailID, String phoneNo, String companyName, String job, String commentText) {
        fullName.sendKeys(name);
        email.sendKeys(emailID);
        phone.sendKeys(phoneNo);
        company.sendKeys(companyName);
        jobTitle.sendKeys(job);
        comment.sendKeys(commentText);
    }

    public  void selectDropdownByExcelValue(WebElement element, String value) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();

        for (WebElement option : options){
            if (option.getText().trim().equalsIgnoreCase(value.trim())) {
                select.selectByVisibleText(option.getText());
                break;
            }
        }
    }

    public  void selectDropDowns(String countryName, String employeeNumber) {
        selectDropdownByExcelValue(country, countryName);
        selectDropdownByExcelValue(employees,employeeNumber);
    }

    public void clickCaptchaCheckbox() {
            WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='reCAPTCHA']")));
            captcha.click();
//        catch (Exception e) {
//            System.out.println("Captcha checkbox not found or already solved");
//            wd.switchTo().defaultContent();
//        }
        }

    public void waitForCaptcha() {
        try {
            System.out.println("Solve Captcha");
            WebDriverWait wait = new WebDriverWait(wd, Duration.ofMinutes(2));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//table[@class = 'rc-imageselect-table-33']")));
            wd.switchTo().defaultContent();
        }
        catch (Exception e) {
            System.out.println("Captcha solved or not detected");
        }
    }

    public  void submitForm() {
        submit.click();
    }

}
