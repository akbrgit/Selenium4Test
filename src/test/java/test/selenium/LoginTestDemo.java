package test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestDemo {
	static WebElement ele=null;
	public static void main(String[] args) throws Exception 
    {
		WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito","start-maximized");
        WebDriver driver =  new ChromeDriver(options); 
        int h=744;
        int w=1382;
        
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.cssSelector("a.login")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input#email")).sendKeys("testdemo@code.in");
        driver.findElement(By.cssSelector("input#passwd")).sendKeys("Tester#123");
        driver.findElement(By.id("SubmitLogin")).click();
        System.out.println(driver.getTitle());
        
        //Dimension d= driver.manage().window().getSize();
        Dimension d2=new Dimension(w-82, h-44);
        driver.manage().window().setSize(d2);
        
        Thread.sleep(3000);
        ele= driver.findElement(By.cssSelector("button[name='submit_search']"));
        int xC=ele.getLocation().getX();
        int yC=ele.getLocation().getY();
        System.out.println(xC+" "+yC);
        Actions act=new Actions(driver);
        act.moveByOffset(xC, yC).click().build().perform();
        
        
        
    }

}
