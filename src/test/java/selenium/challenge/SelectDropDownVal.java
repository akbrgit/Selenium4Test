package selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownChallenge {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--incognito");
		WebDriver driver=new ChromeDriver(opt);

		driver.get("https://www.eurocarparts.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[@title='Batteries'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@title='Add to Basket'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='btn-col']//a[@title='View Basket']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(@class,'prdQty')]")).click();
		String qty="4";
		Thread.sleep(1500);
		driver.findElement(By.xpath("//ul[@class='list']//li[@data-value='"+qty+"']")).click();


	}

}
