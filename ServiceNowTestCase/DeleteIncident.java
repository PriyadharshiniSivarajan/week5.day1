package ServiceNowTestCase;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident extends BaseClass {
@Test
	public  void deleteIncidnet() throws InterruptedException {
		
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("INC0010047",Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("INC0010047",Keys.ENTER);
		String text = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		if(text.contains("No record"))
		{
			System.out.println("Incident deleted");
		}
		else
		{
			System.out.println("Incident not deleted");
		}

	}

}
