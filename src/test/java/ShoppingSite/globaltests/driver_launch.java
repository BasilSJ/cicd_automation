package ShoppingSite.globaltests;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ShoppingSite.Order_framework.landingpage;



public class driver_launch {
	public WebDriver driver;
	public landingpage ob;
	
	public WebDriver launch() throws IOException {
	Properties ab=new Properties();
	FileInputStream p=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\ShoppingSite\\globalproperties\\init.properties");
	ab.load(p);
	String browser=System.getProperty("browser")!=null?System.getProperty("browser"):ab.getProperty("browser");
			
	
	if(browser.equalsIgnoreCase("Chrome"))
	{
		
		driver = new ChromeDriver();
		
		
			
		
	}
	if(browser.equalsIgnoreCase("edge"))
	{
		System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\driver\\msedgedriver.exe" );
		driver = new EdgeDriver();
		
		
			
		
	}
	
	
	
	return driver;
	
	}
	
public List<HashMap<String, String>> jsonextractor(String path) throws IOException
{
	
	String json=FileUtils.readFileToString(new File(path),StandardCharsets.UTF_8);
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String, String>> data=mapper.readValue(json,new TypeReference<List<HashMap<String, String>>>(){});
	return data;
}

public static String screenshot(String testcasename, WebDriver driver) throws IOException
{
	TakesScreenshot t=(TakesScreenshot)driver;
	File source=t.getScreenshotAs(OutputType.FILE);
	String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	File file=new File(System.getProperty("user.dir")+"//screenshot//"+testcasename +timestamp+ ".png");
	FileUtils.copyFile(source, file);
	return (System.getProperty("user.dir")+"//screenshot//"+testcasename +timestamp+ ".png");
}



	@BeforeMethod
	public void broswer_maximize() throws IOException
	{
		driver=launch();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	ob=new landingpage(driver);
	
}
	
	@AfterMethod
	public void close()
	{driver.quit();}

	
	
}