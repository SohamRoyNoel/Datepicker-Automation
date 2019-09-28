package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datepicker extends Thread {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
				driver.manage().window().maximize();
				String expmonth = "March 2030";
				String expdate = "20";
				
			    String baseUrl = "https://www.phptravels.net/";

			    driver.get(baseUrl);
			    
			    driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div/input")).click();
			    Thread.sleep(2000);
			    
			    // Month
			    while (true) {
			    	// get the month name
			    	String accmonth = driver.findElement(By.xpath("/html/body/div[13]/div[1]/table/thead/tr[1]/th[2]")).getText(); 
			    	
			    	// loop it untill it reaches the expected
			    	if (accmonth.equals(expmonth)) {
						break;
					} else {
						driver.findElement(By.xpath("/html/body/div[13]/div[1]/table/thead/tr[1]/th[3]")).click();
					}
				}
			    
			    
			    // Date
			    while(true) {
			    	// get the current date
			    	for (int i = 1; i <= 6; i++) {
						for (int j = 1; j <= 7; j++) {
							String accdate = driver.findElement(By.xpath("/html/body/div[13]/div[1]/table/tbody/tr["+ i +"]/td["+ j +"]")).getText();
							
							if (accdate.equals(expdate)) {
								driver.findElement(By.xpath("/html/body/div[13]/div[1]/table/tbody/tr["+ i +"]/td["+ j +"]")).click();
								break;
							}
						}
					}
			    }
			    
	}

}
