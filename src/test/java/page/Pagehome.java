package page;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Pagehome {
	WebDriver driver;
	By b=By.xpath("//*[@id=\"content_wrapper\"]/section/section/div[1]/div[4]/div[4]");
	By a=By.xpath("//a[@href='https://www.snapdeal.com/products/digital-entertainment']");
	By pricefrom=By.xpath("//input[@name='fromVal']");
	By priceto=By.xpath("//input[@name='toVal']");
	By go=By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']");
	By radio=By.xpath("//label[@for='avgRating-4.0']");
	By option=By.xpath("//a[@class='trending-keyword-search-links catTrendKeyword hashAdded'][normalize-space()='kurti set']");
	By k=By.xpath("//*[@id=\"674299353828\"]/div[2]/div[2]/div");
	By size=By.xpath("//div[@class='attr-val'][normalize-space()='S']");
	By clr=By.xpath("//div[@class='attr-img']//img");
	By chart=By.xpath("//a[@class='view-size-chart']");
    By buy=By.xpath("//span[normalize-space()='buy now']");
    By prty=By.xpath("//div[@class='sort-selected']");
    By list=By.xpath("//li[normalize-space()='Discount']");
    By cler=By.xpath("//*[@id=\"inputValEnter\"]");
	public Pagehome(WebDriver driver) {
		this.driver=driver;
	}
	public  void pageclick()
	{
	
			    driver.findElement(a).click();
	    
	}
	public void priceset() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement pricef = driver.findElement(pricefrom);
        pricef.clear();
        driver.findElement(pricefrom).sendKeys("500");
        WebElement pricet = driver.findElement(priceto);
        pricet.clear();
        driver.findElement(priceto).sendKeys("1000");
        driver.findElement(go).click();
        driver.findElement(prty).click();
        WebElement element = driver.findElement(list);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element.click();
        WebElement checkbox = driver.findElement(radio);
        checkbox.click();
        
       
	}
}
	
	
        
  


