package selenium_final;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Assignment {
	WebDriver driver;
	@BeforeTest
	public void setup() throws InterruptedException {
		ChromeDriverManager .chromedriver().setup();//to set the path
		driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/sound-forge-pro-11-recurring");//to retrive the url
        driver.manage().window().maximize();
		Thread.sleep(1000);
		}
	@DataProvider(name="pull")
	public Object[][] pull() throws EncryptedDocumentException, IOException {
		pull_data pl=new pull_data();
		Object[][]data=pl.pulldatafromexcel();//created object for pull data
		return data;
		}
	@Test(dataProvider="pull" ,priority = 0)
	public void details(String Gender,String First_name,String Last_name,String Day,String Month,String Year,String Email,String Company,String Password,String Confirm_password) throws InterruptedException {
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(1000);
		WebElement male=driver.findElement(By.id("gender-male"));
		Thread.sleep(1000);
		WebElement female=driver.findElement(By.id("gender-female"));
		if(Gender.equals(male.getAttribute("value"))) {
			male.click();
			}
		else
			if(Gender.equals(female.getAttribute("value"))) {
				female.click();
			}
		WebElement firstname=driver.findElement(By.id("FirstName"));
		firstname.sendKeys(First_name);
		Thread.sleep(1000);
		WebElement lastname=driver.findElement(By.id("LastName"));
		lastname.sendKeys(Last_name);
		Thread.sleep(1000);
		WebElement day=driver.findElement(By.name("DateOfBirthDay"));
		Select select=new Select(day);
		select.selectByVisibleText(Day);
		//day.sendKeys(Day);
		Thread.sleep(1000);
		WebElement month=driver.findElement(By.name("DateOfBirthMonth"));
		Select select1=new Select(month);
		select1.selectByVisibleText(Month);
		//month.sendKeys(Month);
		Thread.sleep(1000);
		WebElement year=driver.findElement(By.name("DateOfBirthYear"));
		Select select2=new Select(year);
		select2.selectByVisibleText(Year);
		//year.sendKeys(Year);
		Thread.sleep(1000);
		WebElement email=driver.findElement(By.id("Email"));
		email.sendKeys(Email);
		Thread.sleep(1000);
		WebElement company=driver.findElement(By.id("Company"));
		company.sendKeys(Company);
		Thread.sleep(1000);
		WebElement password=driver.findElement(By.id("Password"));
		password.sendKeys(Password);
		Thread.sleep(1000);
		WebElement confpass=driver.findElement(By.id("ConfirmPassword"));
		confpass.sendKeys(Confirm_password);
		Thread.sleep(1000);
		driver.findElement(By.id("register-button")).click();
		}
	@Test(priority = 1)
	public void login() throws InterruptedException {
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("Email")).sendKeys("sms@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.name("Password")).sendKeys("mane43");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Books")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Fahrenheit 451 by Ray Bradbury")).click();
		Thread.sleep(1000);
		//driver.findElement(By.linkText("FriendEmail")).click();
		//Thread.sleep(1000);
		driver.findElement(By.id("add-to-cart-button-37")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("add-to-wishlist-button-37")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Email a friend']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("FriendEmail")).sendKeys("varshamane2030@gmail.com");
		Thread.sleep(1000);
		//driver.findElement(By.id("YourEmailAddress")).sendKeys("varsharani.mane@moolyed.com");
		//Thread.sleep(1000);
		driver.findElement(By.id("PersonalMessage")).sendKeys("hi");
		Thread.sleep(1000);
		driver.findElement(By.name("send-email")).click();
		Thread.sleep(1000);
		//driver.findElement(By.linkText("Shopping cart")).click();
		//Thread.sleep(1000);
		//driver.findElement(By.id("updatecart")).click();
		//Thread.sleep(1000);
	     driver.findElement(By.linkText("Digital downloads")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("If You Wait (donation)")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("add-to-cart-button-35")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Shopping cart")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("updatecart")).click();
		Thread.sleep(1000);
		Thread.sleep(1000);WebElement dp=driver.findElement(By.id("checkout_attribute_1"));
		Select gift=new Select(dp);
	    gift.selectByVisibleText("Yes [+$10.00]");
	    Thread.sleep(1000);
	    driver.findElement(By.id("termsofservice")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(1000);
		}



}
