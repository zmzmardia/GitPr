package com.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {
	public WebDriver dr;
	public Utility(WebDriver dr) {
		this.dr = dr;
	}
	
	public static Properties readProp(String fileName) throws IOException {
		FileInputStream fs = new FileInputStream(new File(fileName));
		Properties p = new Properties();
		p.load(fs);
		return p;
	}
	
	public void getAnyUrl(String url) {
		dr.get(url);
	}
	
	public void click() {
		dr.findElement(By.id("email")).click();
	}
	
	public void click(By by) {
		dr.findElement(by).click();
	}
	public void click(WebElement ele) {
		ele.click();
	}
	
	public void type(By by, String value) {
		dr.findElement(by).sendKeys(value);
	}


}
