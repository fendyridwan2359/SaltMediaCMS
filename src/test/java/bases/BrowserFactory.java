/**
 * dfdfddf
 */
package bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author fendyridwan
 *
 */
public class BrowserFactory 
{
	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url, String headless) 
	{
		//System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		System.out.println("coba jalan gak ?");
		if(browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/home/ec2-user/seleniumdriver/chromedriver");
			if(headless.equals("true"))
			{
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--headless");
				driver = new ChromeDriver(option);
			}
			else
			{
				driver = new ChromeDriver();
			}
			
			
		}
		else if(browserName.equals("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		return driver;
	}

}
