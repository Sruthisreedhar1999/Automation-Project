package page;

import java.time.Duration;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;


public  class Searchpage {
	WebDriver driver;
	By search=By.name("keyword");
	By product=By.xpath("//img[@src='https://n4.sdlcdn.com/imgs/k/e/z/230X258_sharpened/HAMT-HT-GR004-BRW-BRW-SDL229932614-1-93d22.jpeg']");
	By addcart=By.xpath("//span[normalize-space()='add to cart']");
	By pin=By.xpath("//*[@id='pincode-check']");
    By viewcart=By.xpath("//div[@class='btn btn-theme-secondary open-cart']");
    By qty=By.xpath("//li[normalize-space()='3']");
    By quantity=By.xpath("//div[@id='CS1']");
    By pay=By.xpath("//input[contains(@value,'PROCEED TO PAY Rs. 1,017')]");
    By cler=By.xpath("//*[@id=\"inputValEnter\"]");
    By cls=By.xpath("//span[contains(@class,'icon-font-grey-size24 close-popup-icon')]//i[contains(@class,'sd-icon sd-icon-delete-sign')]");
	public Searchpage(WebDriver driver) {
		this.driver=driver;
	}
	public  void searchitem()
	{
		
			driver.findElement(search).sendKeys("watch",Keys.ENTER);
	}
	
		public void productpage() {
		    String pw = driver.getWindowHandle();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(product));

		    WebElement firstResult = driver.findElement(product);
		    firstResult.click();
		    driver.findElement(product).click();
		    Set<String> allwh = driver.getWindowHandles();
		    for (String handle : allwh) {
		        if (!handle.equalsIgnoreCase(pw)) {
		            try {
		                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		                driver.switchTo().window(handle);
		                driver.findElement(pin).sendKeys("690517", Keys.ENTER);
		                driver.findElement(addcart).click();
		                driver.findElement(viewcart).click();
		                WebElement element = driver.findElement(quantity);
		                Actions actions = new Actions(driver);
		                actions.moveToElement(element).perform();
		                element.click();
		                WebElement element1 = driver.findElement(qty);
		                actions.moveToElement(element).perform();
		                element1.click();
		                driver.findElement(pay).click();
		                driver.close();
		            } catch (StaleElementReferenceException e) {
		                System.out.println("StaleElementReferenceException occurred. Retrying...");
		                driver.switchTo().window(handle);
		                driver.findElement(pin).sendKeys("690517", Keys.ENTER);
		                driver.findElement(addcart).click();
		                driver.findElement(viewcart).click();
		                WebElement element = driver.findElement(quantity);
		                Actions actions = new Actions(driver);
		                actions.moveToElement(element).perform();
		                element.click();
		                WebElement element1 = driver.findElement(qty);
		                actions.moveToElement(element).perform();
		                element1.click();
		                driver.findElement(pay).click();
		                driver.close();
		            }
		        }
		        driver.switchTo().window(pw);
		    }
		}
}
		

