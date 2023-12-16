import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Framework1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		System.out.println(driver.findElement(By.id("draggable")).getText());
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable")); 
		WebElement destnation = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, destnation).build().perform();
		driver.switchTo().defaultContent();
		//driver.findElement(By.id("draggable")).click();
		Set<String> w = driver.getWindowHandles(); 
		
	}



}