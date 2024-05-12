package com.javaautomation2;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javaautomation2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\thasleem\\Downloads\\chromedriverwin\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.way2automation.com/demo.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//*[text()='Registration'])[1]")).click();
		Set<String> wh=driver.getWindowHandles();
		Iterator<String> i1=wh.iterator();
		String mainwindow=driver.getWindowHandle();
		System.out.print(mainwindow);
		System.out.print(wh);
		while(i1.hasNext())
		{
			String childwindow=i1.next(); 
			if(!mainwindow.equalsIgnoreCase(childwindow))
			{
				driver.switchTo().window(childwindow);
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//*[@id=\"load_form\"]/div[2]/div/p[1]/a)[2]")).click();
				driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div/div[5]/ul/li/a/figure")).click();
				Set<String> wh1=driver.getWindowHandles();
				Iterator<String> i2=wh1.iterator();
				while(i2.hasNext())
				{
					String childwindow1=i2.next(); 
					if(mainwindow.equalsIgnoreCase(childwindow1) && !childwindow.equalsIgnoreCase(childwindow1))
					{
						driver.switchTo().window(childwindow1);
						
						WebElement e=driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[9]/input"));
					e.sendKeys("C:\\Users\\sh\\Desktop\\Jan.jpg");
					driver.close();
					}
				}
				driver.switchTo().window(childwindow);
				driver.findElement(By.xpath("//*[@src='images/tooltip.jpg']")).click();
//				Thread.sleep(1000);
			
				Set<String> wh2=driver.getWindowHandles();
				Iterator<String> i3=wh2.iterator();
				while(i3.hasNext())
				{
					String childwindow2=i3.next(); 
					if(!mainwindow.equalsIgnoreCase(childwindow2) && !childwindow.equalsIgnoreCase(childwindow2))
					{
						driver.switchTo().window(childwindow2);
						WebElement wb=driver.findElement(By.xpath("//*[@id=\'example-1-tab-1\']/div/iframe"));
						driver.switchTo().frame(wb);
						WebElement e1=driver.findElement(By.xpath("//*[text()='Tooltips']"));
								String tooltiptext=e1.getAttribute("title");
						System.out.print('\n'+tooltiptext);
						driver.close();
					}
				}
				driver.switchTo().window(childwindow);
				

			}
		}

	}

}
