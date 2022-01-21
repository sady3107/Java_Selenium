package com.tcs;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Adactin_Runner {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mohammbm\\eclipse-workspace\\Selenium_10AM\\Driver\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.get("https://adactinhotelapp.com/index.php");
		dr.manage().window().maximize();
		dr.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("sady1994");
		dr.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("sady12");
		dr.findElement(By.xpath("//*[@id=\"login\"]")).click();
		WebElement loc = dr.findElement(By.xpath("//*[@id=\"location\"]"));
		Select s = new Select(loc);
		s.selectByValue("London");
		Thread.sleep(500);
		WebElement hotel = dr.findElement(By.xpath("//*[@id=\"hotels\"]"));
		Select s1 = new Select(hotel);
		s1.selectByValue("Hotel Sunshine");
		Thread.sleep(500);
		WebElement rt = dr.findElement(By.xpath("//*[@id=\"room_type\"]"));
		Select s2 = new Select(rt);
		s2.selectByValue("Super Deluxe");
		Thread.sleep(500);
		WebElement num_room = dr.findElement(By.xpath("//*[@id=\"room_nos\"]"));
		Select s3 = new Select(num_room);
		s3.selectByVisibleText("5 - Five");
		Thread.sleep(500);
		WebElement in_date = dr.findElement(By.xpath("//*[@id=\"datepick_in\"]"));
		in_date.clear();
		in_date.sendKeys("01/02/2022");
		WebElement out_date = dr.findElement(By.xpath("//*[@id=\"datepick_out\"]"));
		out_date.clear();
		out_date.sendKeys("04/02/2022");
		WebElement adults = dr.findElement(By.xpath("//*[@id=\"adult_room\"]"));
		Select s4 = new Select(adults);
		s4.selectByIndex(3);
		Thread.sleep(500);
		WebElement childs = dr.findElement(By.xpath("//*[@id=\"child_room\"]"));
		Select s5 = new Select(childs);
		s5.selectByIndex(2);
		Thread.sleep(500);
		dr.findElement(By.xpath("//*[@id=\"Submit\"]")).click();
		Thread.sleep(500);
		dr.findElement(By.xpath("//*[@id=\"radiobutton_0\"]")).click();
		dr.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		Thread.sleep(500);
		dr.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Sadiq");
		dr.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Ali");
		dr.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Chennai");
		dr.findElement(By.xpath("//*[@id=\"cc_num\"]")).sendKeys("1234432112344321");
		WebElement cc_type = dr.findElement(By.xpath("//*[@id=\"cc_type\"]"));
		Select s6 = new Select(cc_type);
		s6.selectByIndex(1);
		Thread.sleep(500);
		WebElement exp_month = dr.findElement(By.xpath("//*[@id=\"cc_exp_month\"]"));
		Select s7 = new Select(exp_month);
		s7.selectByVisibleText("April");
		Thread.sleep(500);
		WebElement exp_year = dr.findElement(By.xpath("//*[@id=\"cc_exp_year\"]"));
		Select s8 = new Select(exp_year);
		s8.selectByIndex(12);
		Thread.sleep(500);
		dr.findElement(By.xpath("//*[@id=\"cc_cvv\"]")).sendKeys("123");
		dr.findElement(By.xpath("//*[@id=\"book_now\"]")).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("window.scrollBy(0,125)");

		TakesScreenshot ts = (TakesScreenshot) dr;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\mohammbm\\Desktop\\hotel booking confirmation.jpg");
		FileHandler.copy(src, dest);
		dr.findElement(By.xpath("//*[@id=\"my_itinerary\"]")).click();
		js.executeScript("window.scrollBy(0,30)");

		File src1 = ts.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("C:\\Users\\mohammbm\\Desktop\\itenary.jpg");
		FileHandler.copy(src1, dest1);

		dr.findElement(By.xpath("//*[@id=\"logout\"]")).click();

		dr.quit();

	}

}
