package Steps;

import Base.BaseStep;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class DataTableWithHeaders extends BaseStep {

    @Given("User is on HRMLogin page1")
    public void userOnHomePage1() throws Exception{
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(3000);
    }

    @When("User enters valid credentials1")
    public void enterCreds1(DataTable table){

        List<Map<String, String>> tableList = table.asMaps(String.class, String.class);

        driver.findElement(By.name("username")).sendKeys(tableList.get(0).get("UserName").toString());
        driver.findElement(By.name("password")).sendKeys(tableList.get(0).get("Password").toString(), Keys.ENTER);
    }

    @Then("User should be able to login successfully and new page open1")
    public void message_displayed_Login_Successfully1() throws Throwable {

        Thread.sleep(3000);
        String newPageText = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6")).getText();
        System.out.println("newPageText :" + newPageText);
        assertThat(newPageText, containsString("PIM"));
        Thread.sleep(3000);
    }

    @After
    public void quit(){

        driver.quit();
    }
}
