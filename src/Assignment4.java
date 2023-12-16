import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Assignment4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		Set<String> windows = driver.getWindowHandles();
		java.util.Iterator<String> it = windows.iterator();
		String parentid = it.next();
		String chilid = it.next();
		driver.switchTo().window(chilid);
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		driver.switchTo().window(parentid);
		System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());
		
		
		
		
		}
}