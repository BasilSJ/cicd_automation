package cucumberStepdefinition;

import java.io.IOException;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ShoppingSite.Order_framework.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinition extends driver_launch {
	cart_add ob1;
	String globalproduct;
  @Given("I landed on application landing page")
	public void I_landed_on_application_landing_page() throws IOException {
	  
	  broswer_maximize();
	  ob.goTo(driver);
		
		
	}
  
  @Given("^I enter (.+) and (.+) in landing page$")
  
  public void I_enter_username_and_password(String name,String password) {
	  
	  ob1=ob.login(name,password);
  }
  
  @When("^I select a product with name (.+)$")
  
  public void select_product(String product) throws InterruptedException
  {  globalproduct=product;
	  List <WebElement>products=ob1.products();
	    
WebElement prod =ob1.filterproductname(products, product);

  }
  @And("Click on submit")
  
  public void submit() throws InterruptedException {
	  ob1.AddtoCart(); 
  }

  @Then("I should get confirmation message")
  
  public void confirmation() {
	  Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='"+ globalproduct+"']")).isDisplayed());  
      driver.quit();
  }
  }

