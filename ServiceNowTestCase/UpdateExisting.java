package ServiceNowTestCase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateExisting extends BaseClass{
@Test
	public  void updateExisting() throws InterruptedException {
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame);
		WebElement searchBox = driver.findElement((By.xpath("(//input[@class='form-control'])[1]")));
		searchBox.sendKeys("INC0010001", Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select drop = new Select(urgency);
		drop.selectByValue("1");
		WebElement state = driver.findElement(By.id("incident.state"));
		Select drop1=new Select(state);
		drop1.selectByValue("2");
		driver.findElement(By.xpath("(//button[@value='sysverb_update'])[1]")).click();
		WebElement status = driver.findElement(By.xpath("//td[text()='In Progress']"));
		String text = status.getText();
		if(text.contains("In Progress"))
		{
		System.out.println("Status Verified");	
		}
		else
		{
			System.out.println("Status is different");
		}
		
		
	     WebElement priority = driver.findElement(By.xpath("//td[text()='3 - Moderate']"));
	     String text2 = priority.getText();
	     if(text2.contains("Moderate"))
	     {
	    	 System.out.println("Priority verified");
	     }
	     else
	     {
	    	 System.out.println("Not verified");
	     }
	
}
}