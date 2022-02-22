package com.hm.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.common.Utility;

public class BaseTest {
	
	public WebDriver dr;
	@BeforeClass
	public void openBrowser() throws IOException {
		Properties pr = Utility.readProp("config.properties");
		String br = pr.getProperty("browser2");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mounia2016\\Downloads\\chromedriver_win32\\chromedriver.exe");
			dr = new ChromeDriver();
		}else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Mounia2016\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			dr = new InternetExplorerDriver();
		}
		Utility u = new Utility(dr);
		String url = pr.getProperty("url");
		u.getAnyUrl(url);
	}
	
	@AfterClass
	public void closeBrowser() {
		dr.quit();
	}

}
