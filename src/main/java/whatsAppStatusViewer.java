package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WhatsAppStatusViewer {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://web.whatsapp.com");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            System.out.println("Scan QR code to log in.");
            Thread.sleep(15000);

            WebElement statusTab = driver.findElement(By.xpath("//div[@title='Status']"));
            statusTab.click();

            List<WebElement> statuses = driver.findElements(By.xpath("//div[contains(@class, '_2SnGR')]"));
            for (WebElement status : statuses) {
                status.click();
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
