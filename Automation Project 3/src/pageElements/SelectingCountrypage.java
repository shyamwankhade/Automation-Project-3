package pageElements;

import java.time.Duration;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class SelectingCountrypage extends AbstractMethods {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public SelectingCountrypage(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//i[@class='icp-radio icp-radio-active'])[1]") WebElement englishlanguage;
	
	@FindBy(xpath="(//span[@class='nav-line-2'])[1]") WebElement hoverEN;
	
	By hoverENBUTTON = By.xpath("(//span[@class='nav-line-2'])[1]");
	
	@FindBy(xpath="(//div[@class='icp-mkt-change-lnk'])[1]") WebElement changeregion ;
	
	@FindBy(xpath="//span[@class='a-dropdown-prompt']") WebElement selectcountry ;
	
	@FindBy(xpath="//input[@class='a-button-input']") WebElement gotowebsitebutton ;
	
	
	public void languageselect() {
		try {
		Hoveranyelement(hoverEN);
		englishlanguage.click();
		String amazonurl = driver.getCurrentUrl();
		Reusableclass rc = new Reusableclass(driver);
		rc.urlEquals(amazonurl);
		
        System.out.println("testcase1------> executed successfully");
		
		} catch (Exception e) {
			System.out.println("Exception occured in testcase1 execution");
		}
		
	}
	
	public void country_select() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String amazon = driver.getTitle();
		
		Reusableclass rc = new Reusableclass(driver);
		rc.titleEquals(amazon);
		try {
		
		Hoveranyelement(hoverEN);
		changeregion.click();
		
		String Country=selectcountry.getText();
		rc.innerTextEquals(selectcountry, Country);
		gotowebsitebutton.click();
		
		Set<String> handles = driver.getWindowHandles();
		for(String st: handles) {
			driver.switchTo().window(st);
			String url=driver.getCurrentUrl();
			
			if(url.equals("https://www.amazon.in/?ref_=icp_country_from_in")) {
				System.out.println("current url="+url);
				break;
			}
		}
				
		System.out.println(driver.getCurrentUrl());
		driver.close();
        System.out.println("testcase2------> executed successfully");
		
		} catch (Exception e) {
			System.out.println("Exception occured in testcase2 execution");
		}
	}
}
