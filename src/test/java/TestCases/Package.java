package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import bases.BaseWeb;
import pages.PackageCreate;
import pages.PackageEdit;
import pages.PackageList;

public class Package extends BaseWeb {
	
	@Test
	public void login() throws InterruptedException
	{
		signIn();
		Thread.sleep(3000);
	}
	
	@Test
	public void I_001_DisplayofPackageList() throws InterruptedException
	{
		PackageList pl = PageFactory.initElements(driver, PackageList.class);
		
		pl.clickNavBar();
		Thread.sleep(2000);
		Assert.assertTrue(pl.firstListTableExist(), "cannot find table list");
		
	}
	
	@Test
	public void I_002_CreateNewPackage() throws InterruptedException
	{
		PackageList pl = PageFactory.initElements(driver, PackageList.class);
		PackageCreate pc = PageFactory.initElements(driver, PackageCreate.class);
		PackageEdit pe = PageFactory.initElements(driver, PackageEdit.class);
		
		pl.clickNavBar();
		Thread.sleep(2000);
		pl.clickNewPackageButton();
		pc.clickContentButton();
		pc.clickFirstLineInContent();
		pc.clickContinueButtonContent();
		pc.clickPriceButton();
		pc.typeStartDate();
		pc.typeEndDate();
		pc.typePrice();
		pc.typeDuration();
		pc.clickContinueButtonPrice();
		pc.clickSaveButton();
		Thread.sleep(2000);
		pc.editPage();
		Thread.sleep(2000);
		Assert.assertEquals(pe.getNumberofDuration(), pc.numberOfDuration());
	}
	
	@Test
	public void I_003_SelectPackageFromList() throws InterruptedException
	{
		PackageList pl = PageFactory.initElements(driver, PackageList.class);
		PackageEdit pe = PageFactory.initElements(driver, PackageEdit.class);
		String id;
		
		pl.clickNavBar();
		Thread.sleep(2000);
		id =  pl.getIdFirstList();
		pl.selectFirstListofTable();
		
		
		//assert from checking the url, the url must contain edit
		Assert.assertTrue(pe.isEditPage(), "this is not edit page");
		//assert from checking the url, whether the url contain the selected id
		Assert.assertTrue(pe.getCurrentUrl(id),"");
	}
	
	@Test
	public void I_004_EditPackage() throws InterruptedException
	{
		PackageEdit pe = PageFactory.initElements(driver, PackageEdit.class);
		
		pe.editPage();
		Thread.sleep(2000);
		scrollUp();
		pe.clickPriceButton();
		pe.typePrice();
		pe.typeDuration();
		pe.clickContinueButtonPrice();
		pe.clickSaveButton2();
		Thread.sleep(2000);
		
		
		Assert.assertTrue(pe.checkUpdateOrNot(), "");
	}

}
