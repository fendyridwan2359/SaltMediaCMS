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

/**
 * @author fendyridwan
 *
 */
public class RedeemVoucher {
WebDriver driver;
	
	public RedeemVoucher(WebDriver driver) {
		this.driver = driver;
	}

	//list page
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div[1]/div[1]/div/ul/li[6]/a")
	@CacheLookup
	WebElement NavigationBar;
	
	@FindBy(how = How.NAME, using = "code")
	@CacheLookup
	WebElement code;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div[2]/div/form/div[2]/button")
	@CacheLookup
	WebElement redeemButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div[2]/div/div/div[2]/div/button")
	@CacheLookup
	WebElement checkOutButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div[2]/div/ul/li")
	@CacheLookup
	WebElement payment;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div[2]/div/div[2]/button")
	@CacheLookup
	WebElement completePaymentButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div[2]/div/div[2]")
	@CacheLookup
	WebElement paymentSuccess;
	
	public void clickNavigationBar() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(NavigationBar)).click();
	}
	
	public void inputCode(String code) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(this.code)).sendKeys(code);
	}
	
	public void clickRedeemButton() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(redeemButton)).click();
	}
	
	public void clickCheckOutButton() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(checkOutButton)).click();
	}
	
	public void selectPayment() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(payment)).click();
	}
	
	public void clickCompletePayment() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(completePaymentButton)).click();
	}
	
	public void redeemVoucher(String a) throws InterruptedException {
		clickNavigationBar();
		Thread.sleep(2000);
		inputCode(a);
		clickRedeemButton();
		clickCheckOutButton();
		selectPayment();
		clickCompletePayment();
		Thread.sleep(2000);
	}
	
	public boolean isPaymentSuccess() {
		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(paymentSuccess)).isDisplayed();
	}

}
