package ServiceNowTestCase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident extends BaseClass {
@Test
	public  void assignIncidnet() throws InterruptedException {
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("INC0010047", Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		Set<String> handle1 = driver.getWindowHandles();
		List<String> listHandle1 = new ArrayList<String>(handle1);
		driver.switchTo().window(listHandle1.get(1));

		driver.findElement(By.xpath("(//button[@name='vcr_next'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Software']")).click();
		driver.switchTo().window(listHandle1.get(0));	
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Assignment group changed");
		driver.findElement(By.id("sysverb_update")).click();
		}

}
