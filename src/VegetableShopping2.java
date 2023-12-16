import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VegetableShopping2 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//In previous exercise we added the single vegetable item in the cart, now we will see how to add multiple vegetable items
		//in the cart by using Array and Array List
		//String promocode = "rahulshettyacademy";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//Implicit wait mechanism
		String[] vegitems = {"Brocolli","Cucumber"};
		
		
		Thread.sleep(2000);
		itemscart(driver,vegitems);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));//Explicit wait mechanism  
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	
	}  
	public static void itemscart(WebDriver driver,String[] vegitems)
	
	{ 
		List<WebElement> items = driver.findElements(By.cssSelector("h4[class='product-name']"));
		int j = 0;
		for(int i = 0;i<items.size();i++)
		{
			String[] name = items.get(i).getText().split("-");
			String formattedName = name[0].trim();
	
			List vegitemslst = Arrays.asList(vegitems);
			if(vegitemslst.contains(formattedName))
			{
		
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
				if(j>vegitems.length)
				
				
				{
			
					break;
				}
	

			
			}
		
		}	
	}
}





