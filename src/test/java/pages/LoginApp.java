/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.BaseWeb;

/**
 * @author fendyridwan
 *
 */
public class LoginApp extends BaseWeb{
	WebDriver driver;
	
	public LoginApp(WebDriver driver) {
		this.driver = driver;
	}

	//list page
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div[1]/div[1]/ul/li[2]/button")
	@CacheLookup
	WebElement loginButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div[2]/div/div/div/button[1]")
	@CacheLookup
	WebElement signInWithEmailButton;
	
	@FindBy(how = How.NAME, using = "email")
	@CacheLookup
	WebElement email;
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement password;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div[2]/div/div/form/button")
	@CacheLookup
	WebElement submitButton;
	
	public void clickLoginButton() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(loginButton)).click();
	}
	
	public void clickLoginWithEmailButton() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(signInWithEmailButton)).click();
	}
	
	public void inputEmail() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(email)).sendKeys("fendy.ridwan@2359media.com");;
	}
	
	public void inputPassword() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(password)).sendKeys("12345678");;
	}
	
	public void clickSubmitButton() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(submitButton)).click();
	}
	
	public void getApp() {
		driver.get(urlApp);
	}
	
	public void login() {
		getApp();
		clickLoginButton();
		clickLoginWithEmailButton();
		inputEmail();
		inputPassword();
		clickSubmitButton();
	}

}
