package selenium.challenge;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ChallengeFirst {

	static ChromeDriver driver=null;
	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		String users=driver.findElement(By.xpath("//div[@id='login_credentials']")).getText();
		users = users.replace("Accepted usernames are:", "");
		String usernames[]=users.split("\n");
		
		String password=driver.findElement(By.xpath("//div[@class='login_password']")).getText();
		password=password.replace("Password for all users:", "").trim();
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(usernames[1]);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		driver.findElement(By.xpath("//div[normalize-space()='$"+maxPrice()+"']/parent::div//button")).click();
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']//a")).click();
		if(driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText().contains("$"+maxPrice())) {
			System.out.println("Correct Item added to cart");
		}
		else {
			System.out.println("Incorrect Item added to cart");
		}
		

	}
	
	private static String maxPrice() {
		double num ;
		double max = 00.00;
		List<WebElement> eles= driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		for(WebElement ele:eles) {
			num = Double.valueOf(ele.getText().replace("$", ""));
			
			if(num>max) {
				max =num;
			}
		}
		return  String.valueOf(max);
	}

}