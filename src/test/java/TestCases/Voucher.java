/**
 * 
 */
package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import bases.BaseWeb;
import pages.LoginApp;
import pages.RedeemVoucher;
import pages.VoucherCreate;
import pages.VoucherEdit;
import pages.VoucherList;

/**
 * @author fendyridwan
 *
 */
public class Voucher extends BaseWeb{
	@Test
	public void login() throws InterruptedException
	{
		signIn();
		Thread.sleep(3000);
	}
	
	@Test
	public void J_001_DisplayofPlaylistList() throws InterruptedException
	{
		VoucherList vl = PageFactory.initElements(driver, VoucherList.class);
		
		vl.clickNavigationBar();
		Thread.sleep(2000);
		Assert.assertTrue(vl.searchFieldExist(),"cannot find search field");
		Assert.assertTrue(vl.createButtonExist(), "cannot find create button");
		Assert.assertTrue(vl.tableExist(), "cannot find table list");
		
	}
	
	@Test
	public void J_002_CreateVoucherManual() throws InterruptedException
	{
		VoucherList vl = PageFactory.initElements(driver, VoucherList.class);
		VoucherCreate vc = PageFactory.initElements(driver, VoucherCreate.class);
		VoucherEdit ve = PageFactory.initElements(driver, VoucherEdit.class);
		
		vl.clickNavigationBar();
		Thread.sleep(2000);
		vl.clickCreateButton();
		vc.inputName();
		vc.typeStartDate();
		vc.typeEndDate();
		//select package
		vc.clickSelectPackageButton();
		vc.selectFirstPackage();
		vc.clickContinueButtonPackage();
		scrollDown();
		//input voucher
		vc.clickGenerateButton();
		vc.inputVoucherCode();
		vc.inputNumberOfVoucher();
		vc.inputPercentageDiscount();
		vc.clickContinuebuttonVoucher();
		scrollUp();
		vc.clickSaveButton();
		Thread.sleep(2000);
		
		//assert from search voucher 
		vc.searchNewVoucher();
		vl.selectFirstTableList();
		Thread.sleep(2000);
		scrollDown();
		Assert.assertTrue(ve.isVoucherManualTrue(vc.throwTime()));
	}
	
	@Test
	public void J_003_CreateVoucherAutomatically() throws InterruptedException{
		VoucherList vl = PageFactory.initElements(driver, VoucherList.class);
		VoucherCreate vc = PageFactory.initElements(driver, VoucherCreate.class);
		VoucherEdit ve = PageFactory.initElements(driver, VoucherEdit.class);
		
		vl.clickNavigationBar();
		Thread.sleep(2000);
		vl.clickCreateButton();
		vc.inputName();
		vc.typeStartDate();
		vc.typeEndDate();
		//select package
		vc.clickSelectPackageButton();
		vc.selectFirstPackage();
		vc.clickContinueButtonPackage();
		scrollDown();
		//input voucher automatically with no input voucher code
		vc.clickGenerateButton();
		//vc.inputVoucherCode();
		vc.inputNumberOfVoucher();
		vc.inputPercentageDiscount();
		vc.clickContinuebuttonVoucher();
		scrollUp();
		vc.clickSaveButton();
		Thread.sleep(2000);
		
		//assert from search voucher 
		vc.searchNewVoucher();
		vl.selectFirstTableList();
		Thread.sleep(2000);
		scrollDown();
		Assert.assertTrue(ve.isVoucherAutomaticallyTrue());
		
	}
	
	@Test
	public void J_004_EditVoucherName() throws InterruptedException{
		VoucherEdit ve = PageFactory.initElements(driver, VoucherEdit.class);
		
		ve.getEditUrl();
		Thread.sleep(2000);
		ve.inputName();
		ve.clickSaveButton();
		Thread.sleep(2000);
		
		//assert from search voucher 
		ve.clickNavigationBar();
		ve.searchNewVoucher();
		Assert.assertTrue(ve.isEditNameWork());
		
	}
	
	@Test
	public void J_005_EditVoucherToAddVoucherCodeManually() throws InterruptedException
	{
		VoucherList vl = PageFactory.initElements(driver, VoucherList.class);
		VoucherEdit ve = PageFactory.initElements(driver, VoucherEdit.class);
		
		vl.clickNavigationBar();
		Thread.sleep(2000);
		vl.clearSearchField();
		vl.typeSearch();
		vl.getFirstNumberOfVoucherFromList();
		//go to edit page
		ve.getEditUrl();
		Thread.sleep(2000);
		ve.inputName();
		scrollDown();
		//input voucher
		ve.clickGenerateButton();
		ve.inputVoucherCode();
		ve.inputNumberOfVoucher();
		ve.inputPercentageDiscount();
		ve.clickContinuebuttonVoucher();
		ve.clickSaveVoucherButton();
		//ve.clickSaveButton();
		Thread.sleep(5000);
		
		//assert from search voucher
		ve.typeSearch();
		Thread.sleep(1000);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ve.throwNumberOfVoucherBefore(), ve.getActualNumberOfVoucher());
		
		//assert from search voucher 
		/*vl.selectFirstTableList();
		Thread.sleep(2000);
		scrollDown();
		Assert.assertTrue(ve.isVoucherManualTrue(ve.throwTime()));
		Thread.sleep(10000);*/
	}
	
	@Test
	public void J_006_EditVoucherToAddVoucherCodeAutomatically() throws InterruptedException
	{
		VoucherList vl = PageFactory.initElements(driver, VoucherList.class);
		VoucherEdit ve = PageFactory.initElements(driver, VoucherEdit.class);
		
		vl.clickNavigationBar();
		Thread.sleep(2000);
		vl.clearSearchField();
		vl.typeSearch();
		vl.getFirstNumberOfVoucherFromList();
		//go to edit page
		ve.getEditUrl();
		Thread.sleep(2000);
		ve.inputName();
		scrollDown();
		//input voucher automatically with no input voucher code
		ve.clickGenerateButton();
		ve.inputNumberOfVoucher();
		ve.inputPercentageDiscount();
		ve.clickContinuebuttonVoucher();
		ve.clickSaveVoucherButton();
		//ve.clickSaveButton();
		Thread.sleep(5000);
		
		//assert from search voucher
		ve.typeSearch();
		Thread.sleep(1000);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ve.throwNumberOfVoucherBefore(), ve.getActualNumberOfVoucher());
	}
	
	@Test
	public void J_007_RedeemVoucher() throws InterruptedException
	{
		SoftAssert sa = new SoftAssert();
		VoucherList vl = PageFactory.initElements(driver, VoucherList.class);
		VoucherEdit ve = PageFactory.initElements(driver, VoucherEdit.class);
		
		vl.clickNavigationBar();
		Thread.sleep(2000);
		vl.clearSearchField();
		vl.typeSearch();
		vl.getNumberOfRedeemedVoucherFromList();
		//go to edit page
		ve.getEditUrl();
		Thread.sleep(2000);
		ve.inputName();
		scrollDown();
		//input voucher
		ve.clickGenerateButton();
		ve.inputVoucherCode();
		ve.inputNumberOfVoucher();
		ve.inputPercentageDiscount();
		ve.clickContinuebuttonVoucher();
		ve.clickSaveVoucherButton();
		Thread.sleep(5000);
		ve.typeSearch();
		Thread.sleep(1000);
		sa.assertEquals(ve.throwNumberOfVoucherBefore(), ve.getActualNumberOfVoucher());
		
		//access app to redeem the voucher
		LoginApp la = PageFactory.initElements(driver, LoginApp.class);
		RedeemVoucher rv = PageFactory.initElements(driver, RedeemVoucher.class);
		la.login();
		rv.redeemVoucher(ve.throwTime());
		sa.assertTrue(rv.isPaymentSuccess(), "");
		
		//back to cms page
		VoucherEdit ve2 = PageFactory.initElements(driver, VoucherEdit.class);
		ve2.getVoucherPage();
		Thread.sleep(2000);
		ve2.clearSearchField();
		ve2.typeSearch();
		Assert.assertEquals(ve2.getNumberOfRedeemedVoucherFromList(), ve2.getActualNumberOfRedeemedVoucher());
		
	}
}
