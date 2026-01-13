package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ContactSalesPage;
import utils.TestDataProvider;

public class ContactSalesTest extends BaseTest {

    @Test(dataProvider = "contactSalesData", dataProviderClass = TestDataProvider.class)
    public void submitUsingExcel(String name, String email, String phone, String country, String company, String job, String emp, String comment) throws InterruptedException {
        ContactSalesPage page = new ContactSalesPage(wd);

        page.acceptCookiesIfPresent();
        page.fillForm(name, email, phone, company, job, comment);
        page.selectDropDowns(country,emp);
        page.clickCaptchaCheckbox();
        page.waitForCaptchaToBeSolved();
        page.submitForm();
        page.isSubmissionSuccessful();
    }
}
