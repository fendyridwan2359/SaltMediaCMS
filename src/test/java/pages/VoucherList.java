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
public class VoucherList {
	WebDriver driver;
	String varTitle = "EditAuto";
	String numberOfVoucherBefore;
	String numberOfRedeemedVoucherBefore;

	public VoucherList(WebDriver driver) {
		this.driver = driver;
	}

	//list page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[3]/ul/a[3]/div")
	@CacheLookup
	WebElement navigationBar;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/input")
	@CacheLookup
	WebElement searchField;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/button")
	@CacheLookup
	WebElement createSeriesButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement tableFirstList;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[3]")
	@CacheLookup
	WebElement tableFirstListNumberOfVoucher;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr/td[4]")
	@CacheLookup
	WebElement tableFirstListNumberOfRedeemedVoucher;
	
	public void clickNavigationBar()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(navigationBar)).click();
	}
	
	public void clickCreateButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(createSeriesButton)).click();
	}
	
	public boolean searchFieldExist()
	{
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clearSearchField()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).clear();
	}
	
	public void typeSearch()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).sendKeys(varTitle);
	}
	
	public void selectFirstTableList()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).click();
	}
	
	public boolean createButtonExist()
	{
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(createSeriesButton)).isDisplayed()==true) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean tableExist()
	{
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).isDisplayed()==true) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean addedSeriesResult()
	{
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText().contains("test Automation")) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String getFirstNumberOfVoucherFromList()
	{
		numberOfVoucherBefore = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstListNumberOfVoucher)).getText();
		return numberOfVoucherBefore;
	}
	
	public String getActualNumberOfVoucher()
	{
		numberOfVoucherBefore = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstListNumberOfVoucher)).getText();
		return numberOfVoucherBefore;
	}
	
	public String throwNumberOfVoucherBefore() {
		return numberOfVoucherBefore;
	}
	
	public String getNumberOfRedeemedVoucherFromList()
	{
		numberOfRedeemedVoucherBefore = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstListNumberOfRedeemedVoucher)).getText();
		return numberOfRedeemedVoucherBefore;
	}
	
	public String getActualNumberOfRedeemedVoucher()
	{
		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstListNumberOfRedeemedVoucher)).getText();
	}

}
