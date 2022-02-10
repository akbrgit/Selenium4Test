package test.selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmulatingMobileDevice {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		
		
		// iPhone 11 Pro dimensions
		/*
		 * DevTools devTools=driver.getDevTools();
		devTools.send(Emulation.setDeviceMetricsOverride(375,
		                                                 812,
		                                                 50,
		                                                 true,
		                                                 Optional.empty(),
		                                                 Optional.empty(),
		                                                 Optional.empty(),
		                                                 Optional.empty(),
		                                                 Optional.empty(),
		                                                 Optional.empty(),
		                                                 Optional.empty(),
		                                                 Optional.empty(),
		                                                 Optional.empty()));
		*/
		
		Map<String, Object> dm= new HashMap<String,Object>();
		dm.put("width", 390);
		dm.put("height", 884);
		dm.put("deviceScaleFactor", 100);
		dm.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", dm);
		
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		
		
	}

}
