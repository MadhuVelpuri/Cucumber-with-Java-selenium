package Steps;

import Base.BaseStep;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class DataTAbleLogin extends BaseStep {


    @Given("User is on HRMLogin page")
    public void userOnHomePage() throws Exception{
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(3000);
    }

    @When("User enters valid credentials")
    public void enterCreds(DataTable table){

        List<String> tableList = table.asList(String.class);

        driver.findElement(By.name("username")).sendKeys(tableList.get(0).toString());
        driver.findElement(By.name("password")).sendKeys(tableList.get(1).toString(), Keys.ENTER);
//        driver.findElement(By.id("login")).click();

    }

    @Then("User should be able to login successfully and new page open")
    public void message_displayed_Login_Successfully() throws Throwable {

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


