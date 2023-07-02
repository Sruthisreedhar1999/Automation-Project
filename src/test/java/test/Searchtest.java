package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Searchpage;
import page.Homepage;

import page.Pagehome;
public class Searchtest extends Baseclass {
	@Test
	public void test() throws IOException 
	{
		Pagehome p=new Pagehome(driver);
		p.pageclick();
	    p.priceset();
	   
	}
	@Test
	public void test1() throws IOException 
	{
		Homepage h=new Homepage(driver);
		h.signin();
		h.title();
		h.logo();
		h.pagesource();
		h.verifyLinks();
	}
	@Test
	public void test2()
	{
		Searchpage s=new Searchpage(driver);
		s.searchitem();
		s.productpage();
		
	}
	
	
}
		
