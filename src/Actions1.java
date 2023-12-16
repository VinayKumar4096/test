import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Actions1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		Actions a = new Actions(driver);
		//If we move our mouse in a specific place then there will be an action to perform for this we are writing the code as below
		//note here we are not clicking the mouse we are just placing/moving the mouse to a specific place
		WebElement move = driver.findElement(By.id("nav-link-accountList"));  
		a.moveToElement(move).contextClick().build().perform();
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		//a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyUp(Keys.SHIFT).sendKeys("HELLO").build().perform();
	
	}


}

