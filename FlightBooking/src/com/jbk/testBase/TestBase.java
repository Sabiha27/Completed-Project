package com.jbk.testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.jbk.webEventListener.WebEventListener;


public class TestBase {
	public static WebDriver driver;
	public FileInputStream fis;
	public Properties pro;
	public EventFiringWebDriver eventHandler;
	public WebEventListener eventListener;

	@BeforeMethod
	public void setEnv() throws InterruptedException, IOException {
		fis = new FileInputStream("config/config.properties");
		pro = new Properties();
		pro.load(fis);

		String pageWaitTime = pro.getProperty("pageWaitTime");
		int page_waitTime = Integer.parseInt(pageWaitTime);

		String implicitWait = pro.getProperty("implicitWaitTime");
		int implicit_Wait = Integer.parseInt(implicitWait);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications"); // disable notification
															// popup
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver78.exe");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(page_waitTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicit_Wait, TimeUnit.SECONDS);

		// hit site URL
		driver.get(pro.getProperty("url"));
		// pro.getProperty("implicitwait");
		eventHandler = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventHandler.register(eventListener);

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}


}
