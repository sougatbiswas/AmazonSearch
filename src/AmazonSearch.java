import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class DropMenu {
	
	static WebDriver driver = new ChromeDriver();
	
		
@Test(priority = 0)
public static void browserSetUp() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Sougat\\chromedriver.exe");
	driver.get("https://www.amazon.in/");
	}
	
@Test(priority = 1)
public static void search() {
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("backpack");
	WebElement ent = driver.findElement(By.id("twotabsearchtextbox"));
	ent.sendKeys(Keys.ENTER);
}

@Test(priority = 2)
public static void addToCart() {
		driver.findElements(By.xpath("//a[@class="+"'a-link-normal a-text-normal'"+"]//*[contains(text(),'Backpack')]")).get(0).click();
		ArrayList WinHandle = new ArrayList (driver.getWindowHandles());
		System.out.println(WinHandle.size());
		driver.switchTo().window((String) WinHandle.get(1));
		driver.getTitle();
}
@Test(priority = 3)
public static void carValidation() {
	driver.findElement(By.id("add-to-cart-button")).click();
	driver.findElement(By.id("hlb-view-cart-announce")).click();
	String prodPrice = driver.findElement(By.id("sc-subtotal-amount-activecart")).getText();
	System.out.println(prodPrice);
	driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']")).click();
	driver.findElement(By.id("quantity_10")).click();
	driver.findElement(By.xpath("//input[@name='quantityBox']")).sendKeys("10");
	driver.findElement(By.id("a-autoid-1-announce")).click();
	driver.navigate().refresh();
	String prodIncreasePrice = driver.findElement(By.id("sc-subtotal-amount-activecart")).getText();
	System.out.println(prodIncreasePrice);
	driver.findElement(By.xpath("//input[@value='Delete']")).click();
}

}
