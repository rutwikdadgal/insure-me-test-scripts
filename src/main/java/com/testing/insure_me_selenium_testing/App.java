package com.testing.insure_me_selenium_testing;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
        //System.setProperty("webdriver.chrome.driver", "C:/softwares/chromedriver-win64/chromedriver-win64/chromedriver.exe");
    	//WebDriverManager.chromedriver().setup();
    	//WebDriverManager.chromedriver().setup();
    	WebDriverManager.chromedriver().setup();
        //WebDriverManager.chromedriver().version("latest").driverRepositoryUrl(new URL("http://chromedriver.storage.googleapis.com/")).setup();


        //WebDriverManager.chromedriver().version("119.0.6045.160").setup();
    	//WebDriverManager.chromedriver().setDriverMirrorURL("http://chromedriver.storage.googleapis.com/").setup();

    	

        System.out.println("script started");
        

        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver((chromeOptions));
        System.out.println("opening url");
        driver.get("http://localhost:8081/contact.html");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        
        System.out.println("Entering details");
        driver.findElement(By.id("inputName")).sendKeys("Rutwik");
        Thread.sleep(3000);
        driver.findElement(By.id("inputNumber")).sendKeys("9999999999");
        Thread.sleep(3000);
        driver.findElement(By.id("inputMail")).sendKeys("rutwik@xyz");
        Thread.sleep(3000);
        driver.findElement(By.id("inputMessage")).sendKeys("Hello! i have submitted the above info.");
        Thread.sleep(3000);
        driver.findElement(By.id("my-button")).click();
        Thread.sleep(3000);
        String response = driver.findElement(By.id("response")).getText();
        System.out.println(response);
        System.out.println("details entered");
        System.out.println("test script executed");
        
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //File destFile = new File ("C:\\Users\\HP\\Pictures\\Screenshots\\test-reports.jpg");
        File destFile = new File ("/var/lib/jenkins/workspace/insure-me-test-scripts/test-reports.jpg");
        FileUtils.copyFile(srcFile, destFile);
        Thread.sleep(3000);
        
        driver.quit();
        
        
    }
}
