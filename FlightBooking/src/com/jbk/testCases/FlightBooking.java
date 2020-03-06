package com.jbk.testCases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jbk.testBase.TestBase;
import com.jbk.utility.Utility;

public class FlightBooking extends TestBase {
	Utility ut = new Utility(driver);
	// public String today;

	@Test
	public void tc01() throws Exception {

		Utility.click_fun("//*[@class='btngdpr']");

		// select departure form
		Thread.sleep(2000);
		Utility.clear_fun("//*[@id='BE_flight_origin_city']");
		Thread.sleep(2000);
		Utility.sendkey_fun("//*[@id='BE_flight_origin_city']", "Pune");
		Thread.sleep(2000);
		Utility.click_fun("//li[@class='active ac_over']");

		// select destination location
		Thread.sleep(2000);
		Utility.clear_fun("//*[@id='BE_flight_arrival_city']");
		Thread.sleep(2000);
		Utility.sendkey_fun("//*[@id='BE_flight_arrival_city']", "Chennai");
		Thread.sleep(2000);
		Utility.click_fun("//li[@class='active ac_over']");

		// confirm departure date
		Thread.sleep(2000);
		Utility.click_fun("//*[@id='BE_flight_origin_date']");
		Thread.sleep(2000);
		System.out.println(11);
		String month1 = "may' 20";
		String date = "08";
		


		
		JavascriptExecutor je = (JavascriptExecutor)driver;
		while (true) {
			String text = driver
					.findElement(By
							.xpath("//*[@id='BE_flight_form_wrapper']/div[1]/div[2]/ul/li[2]/ul/li[1]/section/div/div[2]/div[2]/div[1]"))
					.getText();
			System.out.println("indate");
			if (text.equals(month1)) {
				System.out.println("month-matched");
				break;

			} else {

				System.out.println("month-didn't match");
				WebElement month = driver.findElement(By.xpath("//*[@id='month-scroll2']"));
				je.executeScript("arguments[0].scrollIntoView(true);", month);
				System.out.println("scroller");
				Utility.click_fun("//*[@id='month-scroll0']/div/div/table/tbody/tr/td"+date+")");
				System.out.println("date select");

			}
		}

		/*
		 * //month table WebElement dateWidgetFrom =
		 * driver.findElement(By.xpath("//*[@id='monthWrapper']")); //table row
		 * List<WebElement> rw = dateWidgetFrom.findElements(By.tagName("tr"));
		 * // List<WebElement> cl =
		 * dateWidgetFrom.findElements(By.tagName("td")); // for(WebElement
		 * cell:cl){ if(cell.getText().equals(today)){ cell.click(); break; } }
		 * Thread.sleep(2000);
		 */
		System.out.println(22);

		// departDate.sendKeys("09/03/2020");

		// add traveller
		Thread.sleep(2000);
		WebElement traveller = driver.findElement(By.xpath("//*[@id='BE_flight_paxInfoBox']/span"));
		traveller.click();

		// mark economy class
		Thread.sleep(2000);
		Utility.click_fun("//*[@id='flight_class_select_child']/ul/li[1]");

		// select non stop trip
		// Thread.sleep(2000);
		Utility.click_fun("//a[@title='Non Stop Flights']");

		// click button search flights
		Thread.sleep(2000);
		Utility.click_fun("//*[@id='BE_flight_flsearch_btn']");

		// set filter
		Thread.sleep(2000);
		Utility.click_fun("//*[@id='Flight-APP']/section/section[1]/div/div[1]/div/div[2]/div[3]");

		// select flight time
		Thread.sleep(2000);
		Utility.click_fun("//*[@id='Flight-APP']/section/section[1]/div/div[2]/div/div/div[3]/div/div/div/label[4]");

		// to handle google ads window
		// Thread.sleep(2000);

		Utility.ad_window_handler();

		/*
		 * String mainWinHandle = driver.getWindowHandle(); // Get your main
		 * window String subWinHandle = null;
		 * 
		 * Set<String> allHandle = driver.getWindowHandles(); // Fetch all
		 * handles Iterator<String> iterator = allHandle.iterator(); while
		 * (iterator.hasNext()) { subWinHandle = iterator.next(); }
		 * driver.switchTo().window(subWinHandle); // switch to popup
		 * 
		 * driver.switchTo().window(mainWinHandle);
		 */
		// select airline names
		// Thread.sleep(2000);
		Utility.click_fun("//*[@id='Flight-APP']/section/section[1]/div/div[2]/div/div/div[4]/div/div[2]/label[4]");
		// Thread.sleep(2000);
		Utility.click_fun("//*[@id='Flight-APP']/section/section[1]/div/div[2]/div/div/div[4]/div/div[2]/label[5]");

		Utility.ad_window_handler();

		// apply filter
		// Thread.sleep(2000);
		Utility.click_fun("//*[@id='Flight-APP']/section/section[1]/div/div[1]/div/div[2]/div/div/div[2]/div[3]/input");

		// filter flights

		// driver.close();

	}
}
