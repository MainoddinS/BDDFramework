package factory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	static Properties p;
	
	public static WebDriver initBrowser() throws IOException {
		switch (getProperties().getProperty("browser").trim().toLowerCase()) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
			break;
		}
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return getDriver();
	}
	
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}


    public static Properties getProperties() throws IOException {
	FileReader file =new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	p = new Properties();
	p.load(file);
	return p;
  }
}
