package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Double_folded_datepicker extends Thread {

	public static void main(String[] args) throws Exception {
	
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
				driver.manage().window().maximize();
				String expmonth = "Nov 2019";
				String expdate = "20";
				
			    String baseUrl = "https://www.expedia.ca/";

			    driver.get(baseUrl);
			    
			    driver.findElement(By.xpath("//*[@id=\"hotel-checkin-hp-hotel\"]")).click();
			    Thread.sleep(2000);
			    
			    // Month
			    while (true) {
			    	// get the month name
			    	String accmonth = driver.findElement(By.xpath("//*[@id=\"hotel-checkin-wrapper-hp-hotel\"]/div/div/div[2]/table/caption")).getText(); 
			    	
			    	// loop it untill it reaches the expected
			    	if (accmonth.equals(expmonth)) {
						break;
					} else {
						// xpath of (>) Button
						driver.findElement(By.xpath("//*[@id=\"hotel-checkin-wrapper-hp-hotel\"]/div/div/button[2]")).click();
					}
				}
			    
		// //*[@id="hotel-checkin-wrapper-hp-hotel"]/div/div/div[2]/table/tbody/tr[1]/td[3]/button	    
			    // Date
			    while(true) {
			    	// get the current date
			    	for (int i = 1; i <= 5; i++) {
						for (int j = 1; j <= 7; j++) {
							String accdate = driver.findElement(By.xpath("//*[@id=\"hotel-checkin-wrapper-hp-hotel\"]/div/div/div[2]/table/tbody/tr["+ i +"]/td["+ j +"]/button")).getText();
							
							if (accdate.equals(expdate)) {
								driver.findElement(By.xpath("//*[@id=\"hotel-checkin-wrapper-hp-hotel\"]/div/div/div[2]/table/tbody/tr["+ i +"]/td["+ j +"]/button")).click();
								break;
							}
						}
					}
			    }

	}

}
