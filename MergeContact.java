package week5Assignment;

import java.util.ArrayList;
import java.util.List;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		//Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		//Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		String windowHandle = driver.getWindowHandle();
		
		//Click on Widget of From Contact
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		
		Set<String> obj = driver.getWindowHandles();
		List<String> tab=new ArrayList<String>(obj);
		
		driver.switchTo().window(tab.get(1));
		//Click on First Resulting Contact
		driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]//a")).click();
		
		driver.switchTo().window(windowHandle);
		//Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		Set<String> obj1= driver.getWindowHandles();
		
		List<String> tab1=new ArrayList<String>(obj1);
		
		driver.switchTo().window(tab1.get(1));
		
		//Click on Second Resulting Contact
		driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[2]//a")).click();
		
		driver.switchTo().window(windowHandle);
		//Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		//Accept the Alert
		TargetLocator switchTo = driver.switchTo();
		switchTo.alert().accept();
				
		String title = driver.getTitle();
		
		//Verify the title of the page
		if (title.contains("View Contact")) {
			System.out.println("the title of the page is same");
			
		}
		else {
			System.out.println("the title of the page is not same");
		}
		
		
		
		
	}

}
