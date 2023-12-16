import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String[] mobiles = { "iphone", "Samsung", "Nokia", "Blackberry" };
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String username = driver.findElement(By.xpath("//i[normalize-space()='rahulshettyacademy']")).getText();
	
		
		String password = driver.findElement(By.xpath("//i[normalize-space()='learning']")).getText();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span[@class='checkmark']")).click();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement staticdropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(staticdropdown);
		
		dropdown.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		addmobiles(driver,mobiles);
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.id("country")).sendKeys("India");
		List<WebElement> options = driver.findElements(By.cssSelector(password));
		WebDriverWait t = new WebDriverWait(driver,Duration.ofSeconds(15));
		t.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(.,'India')]//a[.='India']")));
		driver.findElement(By.xpath("//div[contains(.,'India')]//a[.='India']")).click();
		
		driver.findElement(By.id("checkbox2")).click();
		driver.findElement(By.cssSelector("input[class='btn btn-success btn-lg']")).click();
	}
	public static void addmobiles(WebDriver driver, String[] mobiles) {
		List<WebElement> mobilecart = driver.findElements(By.xpath("//h4[@class='card-title']//a"));
		int j = 0;
		for (int i = 0; i < mobilecart.size(); i++) {
			String[] mcart = mobilecart.get(i).getText().split(" ");
			String formattedname = mcart[0].trim();
			System.out.println(formattedname);
	
			List mobileslst = Arrays.asList(mobiles);
			if (mobileslst.contains(formattedname)) {
				j++;
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
				if (j > mobiles.length)
					
				{
					break;
				}
			}

		
		
		}

	}
}