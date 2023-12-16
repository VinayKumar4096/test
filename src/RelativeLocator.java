import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class RelativeLocator {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement name_id = driver.findElement(By.name("name"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(name_id)).getText());
		WebElement dob = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		
		driver.findElement(with(By.tagName("input")).below(dob)).click();
		WebElement text = driver.findElement(By.id("exampleCheck1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(text)).getText());
		WebElement text1 = driver.findElement(By.id("inlineRadio1"));
		
		
		System.out.println(driver.findElement(with(By.tagName("label")).toLeftOf(text1)).getText());
	}
}