/**
 * 
 */
package pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import bases.BaseWeb;

/**
 * @author fendyridwan
 *
 */
public class VoucherCreate{
	WebDriver driver;
	String varTitle = "test Auto";
	String whatTime;
	SoftAssert sa;
	
	public VoucherCreate(WebDriver driver) {
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
	
	//Create Page
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement name;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div[1]/div[1]")
	@CacheLookup
	WebElement startDateLabel;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div[1]/div[1]")
	@CacheLookup
	WebElement endDateLabel;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div[1]/div[2]/div/div[2]/div/div[2]/div/div/input")
	@CacheLookup
	WebElement startDate;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div[3]/div/div/div[1]/div[1]/button[2]")
	@CacheLookup
	WebElement nextMonthButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div/div[1]/div[1]/button[1]")
	@CacheLookup
	WebElement prevMonthButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div/div[2]/div/div[2]/div[1]/button")
	@CacheLookup
	WebElement pickStartDate;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div[1]/div[2]/div/div[2]/div/div[3]/div/div/input")
	@CacheLookup
	WebElement endDate;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div/div[1]/div[1]/button[2]")
	@CacheLookup
	WebElement nextMonthButton2;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div/div[1]/div[1]/button[1]")
	@CacheLookup
	WebElement prevMonthButton2;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div/div[2]/div/div[4]/div[7]/button")
	@CacheLookup
	WebElement pickStartDate2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div[2]/div/div/div[1]/button")
	@CacheLookup
	WebElement buttonPackage;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[2]/div[1]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement selectFirstPackage;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[2]/div[4]/div[2]/button")
	@CacheLookup
	WebElement continueButtonPackage;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/button")
	@CacheLookup
	WebElement generateButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[2]/form/div/div[1]/div/div/input")
	@CacheLookup
	WebElement voucherCode;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[2]/form/div/div[2]/div/div/input")
	@CacheLookup
	WebElement numberOfVoucher;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[2]/form/div/div[3]/div/div/input")
	@CacheLookup
	WebElement percentageDiscount;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[2]/form/div/div[4]/div[2]/button")
	@CacheLookup
	WebElement continueButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div[1]/div[2]/div/div[1]/button")
	@CacheLookup
	WebElement addButton;
	
	
	//List Page
	public void clickNavigationBar()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(navigationBar)).click();
	}
	
	public void clickNewSeriesButton()
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
	
	
	//Create Page
	public String getTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMDDYYhhmms");
		LocalDateTime now = LocalDateTime.now();
		whatTime = dtf.format(now);
		return whatTime;
	}
	
	public String throwTime() {
		return whatTime;
	}
	
	public void inputName() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(name)).sendKeys(getTime());
	}
	
	public void typeStartDate() throws InterruptedException
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(startDate)).click();
		
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(prevMonthButton)).click();
			
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(pickStartDate)).click();
		
		Point p= startDateLabel.getLocation();

		Actions actions = new Actions(driver);
		Thread.sleep(1000);

		actions.moveToElement(startDateLabel).moveByOffset(p.x,p.y).click().perform();
		
		Thread.sleep(2000);
	}
	
	
	public void typeEndDate() throws InterruptedException
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(endDate)).click();
		
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(nextMonthButton2)).click();
		
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(pickStartDate2)).click();
		
		Point p= endDateLabel.getLocation();

		Actions actions = new Actions(driver);
		Thread.sleep(1000);

		actions.moveToElement(endDateLabel).moveByOffset(p.x,p.y).click().perform();
		
		Thread.sleep(2000);
		
	}
	
	public void clickSelectPackageButton() throws InterruptedException {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(buttonPackage)).click();
		Thread.sleep(2000);
	}
	
	public void selectFirstPackage() throws InterruptedException {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(selectFirstPackage)).click();
		
	}
	
	public void clickContinueButtonPackage() throws InterruptedException {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(continueButtonPackage)).click();
		
	}
	
	public void clickGenerateButton() throws InterruptedException {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(generateButton)).click();
		
	}
	
	public void inputVoucherCode() throws InterruptedException {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(voucherCode)).sendKeys(whatTime);
		
	}
	
	public void inputNumberOfVoucher() throws InterruptedException {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(numberOfVoucher)).sendKeys("1");
		
	}
	
	public void inputPercentageDiscount() throws InterruptedException {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(percentageDiscount)).sendKeys("50");
		
	}
	
	public void clickContinuebuttonVoucher() throws InterruptedException {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(continueButton)).click();
	
	}
	
	public void clickSaveButton() throws InterruptedException {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(addButton)).click();
		
	}
	
	public void searchNewVoucher() throws InterruptedException {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).clear();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).sendKeys(whatTime);
		Thread.sleep(2000);
	}
	
	public boolean isNewVoucherSaved() {
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText().contains(whatTime)) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
