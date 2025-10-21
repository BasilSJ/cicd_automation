package ShoppingSite.Order_framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ShoppinSite.reusableassets.reusable;

public class landingpage extends reusable{

	WebDriver driver;
	public landingpage(WebDriver driver) {
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver,this);
	}
	
	//driver.findElement(By.id("userEmail")).sendKeys("bsj@gmail.com");
	@FindBy(id="userEmail")
	WebElement name;
	
	@FindBy(css="#userPassword")
	WebElement password1;
	
	@FindBy(id="login")
	WebElement login;
	
	
public cart_add login(String username,String password) {
	
	name.sendKeys(username);
	password1.sendKeys(password);
	login.click();
	
	return new cart_add(driver);
}

public void goTo(WebDriver driver) {
	driver.get("https://rahulshettyacademy.com/client");
}
}
