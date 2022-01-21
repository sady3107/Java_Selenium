package com.tcs;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Automation_Runner 
{
	public static void main(String[] args) throws InterruptedException, AWTException, IOException 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mohammbm\\eclipse-workspace\\Selenium_10AM\\Driver\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.get("http://automationpractice.com/index.php");
		dr.manage().window().maximize();
		dr.findElement(By.xpath("//a[@class='login']")).click();
		Thread.sleep(1500);
		dr.findElement(By.id("email")).sendKeys("sadiq94@outlook.com");
		dr.findElement(By.id("passwd")).sendKeys("sady1");
		dr.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		dr.findElement(By.xpath("(//a[text()='T-shirts'])[2]")).click();
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,-1300)");
		Actions ac = new Actions(dr);
		WebElement outer_frame = dr.findElement(By.xpath("//div[@class='product-container']"));
		ac.moveToElement(outer_frame).build().perform();
		Thread.sleep(200);
		WebElement qv = dr.findElement(By.xpath("//span[text()='Quick view']"));
		ac.click(qv).build().perform();
		WebElement out_frame = dr.findElement(By.xpath("//iframe[@class='fancybox-iframe']"));
		dr.switchTo().frame(out_frame);
		Thread.sleep(500);
		WebElement cart = dr.findElement(By.xpath("(//span[text()='Add to cart'])[1]"));
	ac.click(cart).build().perform();
	dr.switchTo().defaultContent();
	Thread.sleep(5000);
	dr.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
	Thread.sleep(3000);
	dr.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
	Thread.sleep(3000);
	dr.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
	dr.findElement(By.id("cgv")).click();
	Thread.sleep(3000);
	dr.findElement(By.xpath("(//span[contains(text(),'Proceed to checkout')])[2]")).click();
	dr.findElement(By.xpath("//a[@title='Pay by check.']")).click();
	dr.findElement(By.xpath("//span[text()='I confirm my order']")).click();
	js.executeScript("window.scrollBy(0,390)");
	TakesScreenshot ts = (TakesScreenshot) dr;
	File start = ts.getScreenshotAs(OutputType.FILE);
	File end = new File("C:\\Users\\mohammbm\\Desktop\\order confirmation.jpg");
	FileHandler.copy(start, end);
	Thread.sleep(2000);
	dr.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a")).click();
	js.executeScript("window.scrollBy(0,360)");	
	File start2 = ts.getScreenshotAs(OutputType.FILE);
	File end2 = new File("C:\\Users\\mohammbm\\Desktop\\order history.jpg");
	FileHandler.copy(start2, end2);
	
	}
}
