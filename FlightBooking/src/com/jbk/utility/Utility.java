package com.jbk.utility;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utility {
	public static WebDriver driver;

	public Utility(WebDriver driver) {
		this.driver = driver;
	}

	public static void click_fun(String ele_xpath) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(ele_xpath)).click();
	}

	public static void sendkey_fun(String ele_xpath, String ele) throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath(ele_xpath)).sendKeys(ele);
	}

	public static void clear_fun(String ele_xpath) throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath(ele_xpath)).clear();
	}
	
	public static String getCurrentDate() throws InterruptedException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 7); 
		Thread.sleep(2000);
		String newDate = sdf.format(cal.getTime()); 
		return(newDate);
	}
	
	
	/*public static void dt() throws Exception{
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		Date dt = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new date());
		cal.add(Calender.DATE, 30);
		String newDate = dateformat.format(cal.getTime());
		
		LocalDate date = LocalDate.now();
		Thread.sleep(2000);
		System.out.println(date);
		Thread.sleep(2000);
		LocalDate date1 = date.plusDays(30);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[@id="+date1+"]")).click();
		//td[@id='09/03/2020']
		//System.out.println(date1);
		//Thread.sleep(2000);
		
		
		
	}
	*/
	public static void ad_window_handler(){
		
		String mainWinHandle = driver.getWindowHandle(); // Get your main window
		String subWinHandle = null;

		Set<String> allHandle = driver.getWindowHandles(); // Fetch all handles
		Iterator<String> iterator = allHandle.iterator();
		while (iterator.hasNext()) {
			subWinHandle = iterator.next();
		}
		driver.switchTo().window(subWinHandle); // switch to popup

		driver.switchTo().window(mainWinHandle);
	}

}
