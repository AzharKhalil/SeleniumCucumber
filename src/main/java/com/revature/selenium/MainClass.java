package com.revature.selenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MainClass {
	
	static WebDriver driver;
	public static void loadBrowser() {
		
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
	} 
	
	public static void searchQuery() {
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 2000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gh-ac\"]")));
		
		
		WebElement search = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
		search.sendKeys("laptop");
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"gh-btn\"]"));
		btn.click();
	} 
	
	public static void navigate() {
	
		
		driver.navigate().to("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("SmashKeys");
		//driver.manage().timeouts().implicitlyWait(20, null);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("btnK")).click();
		WebElement e = driver.findElement(By.xpath("//*[@id=\"rso\"]/div/div[1]/div/div[1]/a"));
		Actions a = new Actions(driver);
		Action mouse = a.moveToElement(e).build();
		mouse.perform();
		
		//driver.findElement(By.xpath("//*[@id=\"rso\"]/div/div[1]/div/div[1]/a")).click();
		//System.out.println(driver.getTitle());
	} 

	public static void main(String[] args) {
		MainClass.loadBrowser();
		MainClass.searchQuery();
		MainClass.navigate();
		
	}
}
