package ShoppingSite.Order_framework;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class login {

	public static void main(String[] args)
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
	
	
	String productName = "iphone 13 pro";
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://rahulshettyacademy.com/client");
	
	driver.findElement(By.id("userEmail")).sendKeys("bsj@gmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("Password1");
	driver.findElement(By.id("login")).click();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
WebElement prod =	products.stream().filter(product->
	product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
	}
	
	public static void clicker (WebElement t,WebDriver driver)
	{  
		WebDriverWait top=new WebDriverWait(driver, Duration.ofSeconds(8));
		WebElement qw=t.findElement(By.xpath("./following::button[2]"));
		top.until(ExpectedConditions.elementToBeClickable(qw));
		
		
		t.findElement(By.xpath("./following::button[text()=' Add To Cart']")).click();
	}
}
