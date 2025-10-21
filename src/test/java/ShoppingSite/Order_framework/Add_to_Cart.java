package ShoppingSite.Order_framework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import ShoppingSite.globaltests.driver_launch;
import junit.framework.Assert;
import Listeners.Retry;


public class Add_to_Cart extends driver_launch{
	HashMap<String, String> map;	
	@Test(dataProvider="getData",retryAnalyzer=Retry.class)

	public void submit_order(HashMap<String,String> saver) throws IOException, InterruptedException
	{
	
		/*
		 * WebDriverManager.chromedriver().setup(); WebDriver driver=new ChromeDriver();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 * driver.manage().window().maximize();
		 * driver.get("https://rahulshettyacademy.com/client");
		 * driver.findElement(By.id("userEmail")).sendKeys("bsj@gmail.com");
		 * driver.findElement(By.cssSelector("#userPassword")).sendKeys("Password1");
		 * driver.findElement(By.cssSelector("#login")).click(); List<WebElement> names=
		 * driver.findElements(By.xpath("//h5/b"));
		 * 
		 * 
		 * 
		 * 
		 * names.stream().filter(t->t.getText().equals("iphone 13 pro")).forEach(s->
		 * clicker(s,driver));
		 */
	
	
	//String productName = "ZARA COAT 3";
	
	
	
	//Add_to_Cart norm=new Add_to_Cart();
	
	
	
	
	
	ob.goTo(driver);
	cart_add ob1=ob.login(saver.get("email"),saver.get("password"));
	
	
	
		List <WebElement>products=ob1.products();
	    String production = saver.get("productName");
WebElement prod =ob1.filterproductname(products, saver.get("productName"));
ob1.AddtoCart();
		
Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='"+production+"']")).isDisplayed());
	
	}
	@DataProvider	
	
	/*public Object[][] getData()
	{
		return new Object [][] {{"bsj@gmail.com","Password1","ZARA COAT 3"},{"bsj@gmail.com","Password1","ZARA COAT 3"}};
	}*/
	
	
	public Object[][]getData() throws IOException
	
	{
		/*
		 * map=new HashMap<String, String>(); map.put("email", "bsj@gmail.com");
		 * map.put("password", "Password1"); map.put("productName", "ZARA COAT 3");
		 * 
		 * HashMap<String, String> map1 = new HashMap<String, String>();
		 * map1.put("email", "bsj@gmail.com"); map1.put("password", "Password1");
		 * map1.put("productName", "ZARA COAT 3");
		 * return new Object[][]{ {map},{map1}};
		
		 */
		List <HashMap<String,String>>data=jsonextractor(System.getProperty("user.dir")+"\\src\\main\\java\\dataloaders\\data.json");
		return new Object[][]{ {data.get(0)},{data.get(1)}};
	 
	}
}
	
	
	
	

