package test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverExceptionTest {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		
		try {
			
			//<ElementNotInteractableException>
			//driver.findElement(By.cssSelector("h2.date-header")).sendKeys("HELLO");
			//<ElementNotInteractableException>
			
			//<--JavascriptException--->
			/*
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			WebElement web=driver.findElement(By.id("ta1"));
			jse.executeScript("arguments[0.value='Hello Mr. Akbar Ali'", web);
			*/
			//<--JavascriptException--->
			
			//<--InvalidSelectorException--->
			//driver.findElement(By.xpath("//input[@value='Search']]")).click();
			//<--InvalidSelectorException--->
			
			//<--StaleElementReferenceException--->
			/*
			WebElement web=driver.findElement(By.id("ta1"));
			web.sendKeys("Hello Akbar");
			driver.findElement(By.linkText("compendiumdev")).click();
			driver.navigate().back();
			driver.navigate().refresh();
			web=driver.findElement(By.id("ta1"));//This line handle the exception
			web.clear();
			*/
			
			//<----->
			//driver.findElement(By.id("alert1")).click();//UnhandledAlertException
			//driver.close();
			//<----->
			
			//<NoSuchSessionException>
			//driver.quit();
			//driver.getTitle();
			//<NoSuchSessionException>
			
			//driver.get("www.cricbuzz.com/");//InvalidArgumentException
			//driver.switchTo().frame("frame");//NoSuchFrameException
			//driver.switchTo().window("FAKEWINDOWID");//NoSuchWindowException
			//driver.switchTo().alert();//NoSuchAlertExcepion
			//driver.findElement(By.id("abcd")).sendKeys("HELLO");//NoSuchElementException
			
		}
		catch(WebDriverException ex) {
		
			System.out.println("***********\n"+ex.getMessage());
			
			
		}
		
		//<--InvalidSelectorException--->
		//driver.findElement(By.xpath("//input[@value='Search']]")).click();
		//<--InvalidSelectorException--->
		
		//<--StaleElementReferenceException--->
		/*
		WebElement web=driver.findElement(By.id("ta1"));
		web.sendKeys("Hello Akbar");
		driver.findElement(By.linkText("compendiumdev")).click();
		driver.navigate().back();
		driver.navigate().refresh();
		web=driver.findElement(By.id("ta1"));//This line handle the exception
		web.clear();
		*/
		//<----->
		//<----->
		//driver.findElement(By.id("alert1")).click();//UnhandledAlertException
		//driver.close();
		//<----->
		//driver.navigate().to("www.cricbuzz.com/");//InvalidArgumentException
		//driver.get("www.cricbuzz.com/");//InvalidArgumentException
		//driver.switchTo().frame("frame");//NoSuchFrameException
		//driver.switchTo().window("FAKEWINDOWID");//NoSuchWindowException
		//driver.switchTo().alert();//NoSuchAlertExcepion
		//driver.findElement(By.id("abcd")).sendKeys("HELLO");//NoSuchElementException
		
		driver.quit();
		

	}

}
