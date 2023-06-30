package Selenium.Amazon;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ecommerce {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("T shirt for men");
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		
		js.executeScript("window.scroll(0,1000)");
		
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[7]/div/div/div/div/div[2]/div/span/a/div/img")).click();
		//click img
		
		
		
		Set<String> newwin=driver.getWindowHandles();
		Iterator<String> it=newwin.iterator();
		String parent=it.next();
		String child=it.next();

		driver.switchTo().window(child);
		Thread.sleep(3000);
		js.executeScript("window.scroll(0,500)");
		
		WebElement ele= driver.findElement(By.xpath("//select[@name=\"dropdown_selected_size_name\"]"));
		Select select =new Select(ele);
		select.selectByIndex(4);
		
//		driver.findElement(By.cssSelector("select[name='dropdown_selected_size_name']")).click();
//		//driver.findElement(By.xpath("//*[@id=\"native_dropdown_selected_size_name\"]")).click();
//		driver.findElement(By.xpath("//*[@id=\"native_dropdown_selected_size_name\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.switchTo().window(child);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"buy-now-button\"]")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}
	

}
