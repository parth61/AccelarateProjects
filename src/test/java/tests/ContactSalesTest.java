package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ContactSalesPage;
import utils.ExcelUtil;

public class ContactSalesTest extends BaseTest {

    @Test
    public void submitUsingExcel() throws Exception {
        ContactSalesPage page = new ContactSalesPage(wd);

        String name = ExcelUtil.getData(1,0);
        String email = ExcelUtil.getData(1,1);
        String phone = ExcelUtil.getData(1,2);
        String country = ExcelUtil.getData(1,3);
        String company = ExcelUtil.getData(1,4);
        String job = ExcelUtil.getData(1,5);
        String emp = ExcelUtil.getData(1,6);
        String comments = ExcelUtil.getData(1,7);

        page.acceptCookiesIfPresent();
        page.fillForm(name, email, phone, company, job, comments);
        page.selectDropDowns(country,emp);
        page.clickCaptchaCheckbox();
        page.waitForCaptchaToBeSolved();
        page.submitForm();
    }
}
