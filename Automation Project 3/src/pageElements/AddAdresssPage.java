package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class AddAdresssPage extends AbstractMethods {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public AddAdresssPage(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	 @FindBy(xpath=" //span[@class='navFooterBackToTopText']") WebElement backtotop ;
	 
	 @FindBy(xpath="//a[text()='Help']")WebElement helpbutton;
	 
	 @FindBy(xpath="(//div[@class='a-box-inner'])[3]")WebElement manageaddress;
	 
	 @FindBy(xpath="//div[@class='a-box first-desktop-address-tile']")WebElement addaddress;
	 
	 @FindBy(xpath="//*[text()='Add a new address']")WebElement addaddressmessage;
	 
     @FindBy(id="address-ui-widgets-enterAddressFullName") WebElement fullname ;
	 
	 @FindBy(id="address-ui-widgets-enterAddressPhoneNumber")WebElement mobilenum;
	 
	 @FindBy(id="address-ui-widgets-enterAddressPostalCode")WebElement pincode;
	 
	 @FindBy(id="address-ui-widgets-enterAddressLine1")WebElement addaddress1;
	 
	 @FindBy(id="address-ui-widgets-enterAddressLine2")WebElement address2;
	 
     @FindBy(id="address-ui-widgets-landmark")WebElement landmark;
	 
	 @FindBy(id="address-ui-widgets-enterAddressCity")WebElement city;
	 
	 @FindBy(id="select2-address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId-container")WebElement state;
	 
	 @FindBy(xpath="//input[@class='select2-search__field']")WebElement entercity;
	 
	 @FindBy(xpath="select2-address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId-result-hztw-Maharashtra")WebElement selectstate; 
	 
	 @FindBy(xpath="(//input[@class='a-button-input'])[3]")WebElement addaddressbutton;
	 
	 @FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") WebElement hoveraccountlist ;
		
	 @FindBy(xpath="//span[text()='Sign Out']") WebElement signout ;
	 
	@SuppressWarnings("resource")
	public void addaddress() throws IOException {
       implicitlywaitmethod();
       FileInputStream fs1 = new FileInputStream(System.getProperty("user.dir") + ("C:\Users\shyam\Downloads\Automation Project 3\Automation Project 3\src\testData\Automation Project 3.xlsx"));

		XSSFWorkbook workbook = new XSSFWorkbook(fs1);
		XSSFSheet sheet = workbook.getSheetAt(0);
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", backtotop);
		helpbutton.click();
		manageaddress.click();
		
		SignInOutPage sn = new SignInOutPage(driver);
		sn.signin();
		
		addaddress.click();
		Reusableclass rc= new Reusableclass(driver);
		rc.innerTextEquals(addaddressmessage, "Add a new address");
		
		fullname.sendKeys((sheet.getRow(0).getCell(1)).toString());
		mobilenum.sendKeys((sheet.getRow(3).getCell(1)).toString());
		pincode.sendKeys((sheet.getRow(4).getCell(1)).toString());
		
		js.executeScript("arguments[0].scrollIntoView();", addaddress1);
		
		addaddress1.sendKeys((sheet.getRow(5).getCell(1)).toString());
		address2.sendKeys((sheet.getRow(6).getCell(1)).toString());
		landmark.sendKeys((sheet.getRow(7).getCell(1)).toString());
		city.sendKeys((sheet.getRow(8).getCell(1)).toString());
		state.click();
		entercity.sendKeys((sheet.getRow(9).getCell(1)).toString());
		selectstate.click();
		addaddressbutton.click();
		
		Hoveranyelement(hoveraccountlist);
		signout.click();
		
         System.out.println("testcase12------> executed successfully");
		
		} catch (Exception e) {
			System.out.println("Exception occured in testcase12 execution");
		}
	}
}
