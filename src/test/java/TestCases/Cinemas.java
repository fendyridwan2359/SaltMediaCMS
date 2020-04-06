/**
 * 
 */
package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import bases.BaseWeb;
import pages.CinemaCreate;
import pages.CinemaEdit;
import pages.CinemasList;
import pages.EventList;

/**
 * @author fendyridwan
 *
 */
public class Cinemas extends BaseWeb{
	
	@Test
	public void login() throws InterruptedException
	{
		signIn();
		Thread.sleep(3000);
	}
	
	@Test
	public void F_001_CheckCinemaList() throws InterruptedException
	{
		CinemasList cl = PageFactory.initElements(driver, CinemasList.class);
		
		cl.clickNavigationBar();
		Thread.sleep(2000);
		Assert.assertTrue(cl.searchFieldExist(),"cannot find search field");
		Assert.assertTrue(cl.createButtonExist(), "cannot find create button");
		Assert.assertTrue(cl.firstListTableExist(), "cannot find table list");
		
	}
	
	@Test
	public void F_002_CreateNewCinemas() throws InterruptedException
	{
		CinemasList cl = PageFactory.initElements(driver, CinemasList.class);
		CinemaCreate cc = PageFactory.initElements(driver, CinemaCreate.class);
		
		cl.clickNavigationBar();
		Thread.sleep(2000);
		
		cl.clickCreateButton();
		cc.clickAddMovieButton();
		cc.searchContentMovie();
		cc.selectFirstListMovie();
		cc.inputURL();
		scrollDown();
		cc.clickShowTimesButton();
		cc.inputTicketId();
		cc.clickSaveShowTimesButton();
		cc.clickSaveButton();
		cl.typeSearch();
		
	}
	
	
	@Test
	public void F_003_EditCinemas() throws InterruptedException
	{
		CinemasList cl = PageFactory.initElements(driver, CinemasList.class);
		CinemaEdit ce = PageFactory.initElements(driver, CinemaEdit.class);
		
		cl.clickNavigationBar();
		cl.clearSearch();
		cl.typeSearch();
		cl.selectFirstListofTable();
		Thread.sleep(2000);
		ce.clearURL();
		ce.inputURL();
		scrollDown();
		ce.clickShowTimesButton();
		ce.inputTicketId();
		ce.clickSaveShowTimesButton();
		ce.clickSaveEditShowTimesButton();
		scrollUp();
		
		ce.clickSaveButton();
		//cl.typeSearch();
		
	}
	
	@Test
	public void F_004_DeleteCinemas() throws InterruptedException
	{
		CinemasList cl = PageFactory.initElements(driver, CinemasList.class);
		CinemaEdit ce = PageFactory.initElements(driver, CinemaEdit.class);
		
		cl.clickNavigationBar();
		cl.clearSearch();
		cl.typeSearch();
		cl.selectFirstListofTable();
		Thread.sleep(2000);
		ce.clickDeleteButton();
		//cl.typeSearch();
		
	}
	

}
