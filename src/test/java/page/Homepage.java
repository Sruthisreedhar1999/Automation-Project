package page;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Homepage {
	WebDriver driver;
	By logoe=By.xpath("//img[@title='Snapdeal']");
	public Homepage(WebDriver driver) {
		this.driver=driver;
	}
	public void signin()
	{
	String src=driver.getPageSource();
	if(src.contains("Sign in"))
	{
		System.out.println("User is already sign in");
	}
	else
	{
		System.out.println("User is not sign in");
	}
	}
	public  void title()
	{
		String expectedTitle = "Digital Entertainment: Buy Digital Movies, Books, Magazines, OGLE & more Online on Snapdeal";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");
	}
	public void logo()
	{
		boolean logo=driver.findElement(logoe).isDisplayed();
		if(logo)
		{
			System.out.println("logo is present");
		}
		else
		{
			System.out.println("logo is not present");
		}
	}
	public void pagesource()
	{
		String src=driver.getPageSource();
		if(src.contains("Gift Cards"))
		{
			System.out.println("Text is present");
		}
		else
		{
			System.out.println("Text is not present");
		}
	}
	public void verifyLinks() {
	    List<WebElement> links = driver.findElements(By.tagName("a"));
	    System.out.println("Total number of links: " + links.size());
	    
	    int count = 0;
	    for (WebElement linkElement : links) {
	        if (count >= 10) {
	            break; 
	        }
	        
	        String link = linkElement.getAttribute("href");
	        try {
	            verifyLinkResponseCode(link);
	            count++;
	        } catch (IOException e) {
	            System.out.println("Exception occurred while verifying link: " + link);
	            e.printStackTrace();
	        }
	    }
	}

	private void verifyLinkResponseCode(String link) throws IOException {
	    URL url = new URL(link);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    connection.connect();
	    int responseCode = connection.getResponseCode();
	    if (responseCode == 200) {
	        System.out.println("Response code is 200: " + link);
	    } else if (responseCode == 404) {
	        System.out.println("Response code is 404: " + link);
	    }
	    connection.disconnect();
	}
}







