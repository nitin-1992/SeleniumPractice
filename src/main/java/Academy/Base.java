package Academy;




	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

	public class Base {
		
		public WebDriver driver;
		public void intializeDriver() throws IOException 
		{
			Properties prop=new Properties();
			String current_Dir=System.getProperty("user.dir")+"\\src\\main\\java\\Academy\\data.properties";
			System.out.println(current_Dir);
			FileInputStream fis=new FileInputStream(current_Dir);
			prop.load(fis);
//			System.out.println(prop.getProperty("browser"));
			String browser_name=prop.getProperty("browser");
			String chromedriverpath=System.getProperty("user.dir")+"\\chromedriver.exe";
			System.out.println(chromedriverpath);
			if(browser_name.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",chromedriverpath);
				driver=new ChromeDriver();
			}	
			
			else if(browser_name.equals("firefox"))
			{
				driver=new FirefoxDriver();
				
			}
			
			else if(browser_name=="IE")
			{
				
			}
			driver.manage().timeouts().implicitlyWait(19,TimeUnit.SECONDS);
			
		}
	


	public static void main(String[] args) throws IOException {
		Base b=new Base();
		b.intializeDriver();

	}

}
