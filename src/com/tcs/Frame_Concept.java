package com.tcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame_Concept {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mohammbm\\eclipse-workspace\\Selenium_10AM\\Driver\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.get("http://www.leafground.com/pages/frame.html");
		dr.manage().window().maximize();
		WebElement frame = dr.findElement(By.xpath("//iframe[@src='default.html']"));
		dr.switchTo().frame(frame);
		dr.findElement(By.id("Click")).click();
		dr.switchTo().defaultContent();
		

	}

}
