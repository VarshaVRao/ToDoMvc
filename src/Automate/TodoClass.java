package Automate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TodoClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			driver.get("http://todomvc.com/examples/react/");
			
			 WebElement toDo = driver.findElement(By.xpath("//input[@class='new-todo']"));        
			 
			 //adding new to dos 
			 toDo.sendKeys("Exercise");
		        toDo.sendKeys(Keys.ENTER);
		        toDo.sendKeys("work");
		        toDo.sendKeys(Keys.ENTER);
		        Thread.sleep(2000);
		        
		        Actions actions = new Actions(driver); 
		        WebElement findElement = driver.findElement(By.xpath("/html/body/section/div/section/ul/li/div/label"));
		        WebElement clickOnDelete = driver.findElement(By.xpath("/html/body/section/div/section/ul/li/div/button"));
		        WebElement editInput = driver.findElement(By.xpath("/html/body/section/div/section/ul/li/input"));
		        System.out.println(findElement.isDisplayed());
		        System.out.println(clickOnDelete.isEnabled()); 
		        
		        //editing todo
		        actions.doubleClick(findElement);
		        actions.perform();
		        System.out.println(editInput.isEnabled());
		        editInput.clear();
		        editInput.sendKeys("New Text Input");
		        editInput.sendKeys(Keys.ENTER);
		        Thread.sleep(2000);
		        
		        //deleting todo
		        actions.moveToElement(findElement);
		        actions.perform();
		        Thread.sleep(2000);
		        clickOnDelete.click();       
		        Thread.sleep(2000);
		        
		       WebElement completed= driver.findElement(By.xpath("//input[@class='toggle']"));
		       completed.click();
		       
		       //to view completed list
		       WebElement link=driver.findElement(By.xpath("//a[contains(.,'Completed')]"));
		       link.click();
		       Thread.sleep(2000);
		        driver.close();
	}

}
