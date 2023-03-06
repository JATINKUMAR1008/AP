package Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class FirstCase {
	
	public static void main(String[] args) throws InterruptedException{
		try{
			System.setProperty("webdriver.chrome.driver", "C:/Users/student/Downloads/chromedriver_win32/chromedriver.exe");
			WebDriver driver= new ChromeDriver(); 
			
			driver.manage().window().maximize();
			driver.get("https://www.google.com/");
			driver.wait(5);
			driver.close();
		}catch(NoClassDefFoundError e){
			System.out.println(e);
		}
	}
}
