package co.selenium_java.test;
import java.util

 .concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
    public static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Embedded\\Desktop\\SQA\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.phptravels.net/");
		driver.manage().window().maximize();
		
		
		String Tour=" ";
		Tour=driver.findElement(By.xpath("//li[3]/button/span/i\", \"xpath:position\");
		System.out.println(Tour);
		
		String SearchDestination=" ";
		SearchDestination=driver.findElement(By.cssSelector("#.select2-search__field")).getText();
		System.out.println(SearchDestination);
		
		String Calander=" ";
		Calander=driver.findElement(By.cssSelector("#dp form-control form-control-lg")).getText();
		System.out.println(Calander);
		
		int Travellers=" ";
		Travellers=driver.findElement(By.cssSelector("#dp form-control form-control-lg")).getText();
		System.out.println(Travellers);
		
		
		WebElement p=driver.findElement(By.name("Tour"));
	      p.sendKeys("Selenium Java");


	}}