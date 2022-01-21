package com.tcs;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Window_Handling {
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mohammbm\\eclipse-workspace\\Selenium_10AM\\Driver\\chromedriver.exe");
		WebDriver w = new ChromeDriver();
		w.get("https://www.myntra.com/");
		w.manage().window().maximize();
		WebElement men = w.findElement(By.xpath("(//a[text()='Men'])[1]"));
		Thread.sleep(700);
		Actions a = new Actions(w);
		a.contextClick(men).build().perform();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement women = w.findElement(By.xpath("(//a[text()='Women'])[1]"));
		a.contextClick(women).build().perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement kid = w.findElement(By.xpath("(//a[text()='Kids'])[1]"));
		a.contextClick(kid).build().perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement hl = w.findElement(By.xpath("(//a[text()='Home & Living'])[1]"));
		a.contextClick(hl).build().perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement beau = w.findElement(By.xpath("(//a[text()='Beauty'])[1]"));
		a.contextClick(beau).build().perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Set<String> wh = w.getWindowHandles();
		for (String str : wh) {
			String title = w.switchTo().window(str).getTitle();
			System.out.println(title);
		}
		String actual = "Kids Clothing - Buy Kids Clothes, Dresses & Bottom wear Online in India";
		for (String title : wh) {
			if (w.switchTo().window(title).getTitle().equals(actual)) {
				continue;
			} else {
				w.close();
			}
		}

	}
}
