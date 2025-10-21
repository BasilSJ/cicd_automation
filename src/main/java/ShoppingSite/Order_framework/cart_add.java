package ShoppingSite.Order_framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import ShoppinSite.reusableassets.reusable;

public class cart_add extends reusable {
   
	WebDriver driver;
	WebDriverWait wait1;
	public cart_add(WebDriver driver) {
		super(driver);
		this.driver=driver;	
		
		PageFactory.initElements(driver,this);
	}
	
	//driver.findElement(By.id("userEmail")).sendKeys("bsj@gmail.com");
	@FindBy(css=".mb-3")
	List<WebElement> product;
	@FindBy(css=".card-body button:last-of-type")
	WebElement addbutton;
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement carter;
	
	By productwait=By.cssSelector(".mb-3");
	By clickerlink=By.cssSelector("button[routerlink='/dashboard/cart']");
	public List<WebElement> products() {
		explicitwaiter(productwait);
		
		return product;
	}
	
	
	public WebElement filterproductname(List<WebElement>products,String productName)
	{
		WebElement answer=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return answer;
		
	}
	
	public void AddtoCart() throws InterruptedException
	{   Thread.sleep(12000);
		addbutton.click();
		Thread.sleep(12000);
		explicitwaiterclicker(clickerlink);
		carter.click();
		
		
}
}