package pageElements;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;
import utilities.ExcelUtility1;
import utilities.Reusableclass;

public class ReturnsPage extends AbstractMethods {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public ReturnsPage(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

    @FindBy(xpath=" //span[@class='navFooterBackToTopText']") WebElement backtotop ;
	
	@FindBy(xpath="//a[text()='Returns Centre']") WebElement returncentrebutton ;	

	@FindBy(xpath="(//h1[@class='a-text-left'])[1]") WebElement returnitemsordered ;
	
	@FindBy(xpath="//*[@id=\"return-center-page-content\"]/div[1]/div[1]/div/div/div[3]/a/div/span") WebElement vieworders ;
	
	@FindBy(xpath="//*[@id=\"manageReturnSection\"]/div/div/div/div[3]/a/div/span") WebElement viewreturns ;
	
	@FindBy(xpath="//a[@id='a-autoid-0-announce']") WebElement viewreurnstatus ;
	
	@FindBy(xpath="//span[text()='Refund issued']") WebElement refundissued ;
	
	@FindBy(xpath="//span[@class='a-size-small atwl-hz-vertical-align-middle']") WebElement createwishlist ;
	
	@FindBy(xpath="//input[@id='list-name']") WebElement listname ;
	
    @FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") WebElement hoveraccountlist ;
	
	@FindBy(xpath="//span[text()='Sign Out']") WebElement signout ;
	
	@FindBy(xpath="(//span[@class='nav-line-2'])[2]") WebElement returns_order;
	
	@FindBy(xpath="//div[@class='a-column a-span6']/child::h1")WebElement yoursorder;
	
	@FindBy(xpath="//li[@class='page-tabs__tab page-tabs__tab--selected']")WebElement orders;
	
	@FindBy(xpath="//span[@id='a-autoid-1-announce']")WebElement dropdown;
	
	@FindBy(xpath="//a[@id='time-filter_2']")WebElement year;
	
	@FindBy(xpath="(//div[@class='a-box-inner'])[1]")WebElement orderplacedBox;
	
	@FindBy(id = "ap_email")WebElement emailaddress;	

	@FindBy(xpath = "//*[@id=\"ap_password\"]")WebElement password;	

	@FindBy(id = "continue")WebElement continuebutton;
	
	@FindBy(id = "signInSubmit")WebElement signin;
	public void returns_items() {
		implicitlywaitmethod();
		
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", backtotop);
		
		returncentrebutton.click();
		SignInOutPage sn = new SignInOutPage(driver);
		sn.signin();
		String iemsorderd=returnitemsordered.getText();
		Reusableclass rc = new Reusableclass(driver);
		rc.innerTextEquals(returnitemsordered,iemsorderd);
		vieworders.click();
		driver.navigate().back();
		viewreturns.click();
		
		viewreurnstatus.click();
		String refund=refundissued.getText();
		rc.innerTextEquals(refundissued,refund);
		Hoveranyelement(hoveraccountlist);
		signout.click();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		String url = prop.getProperty("url");
		driver.get(url);
		System.out.println("testcase9------> executed successfully");
		
		} catch (Exception e) {
			System.out.println("Exception occured in testcase9 execution");
		}
	}
	
	public void returnsandorders() {
		implicitlywaitmethod();

		try {
			returns_order.click();
			ExcelUtility1 xs = new ExcelUtility1();

			String emailid = xs.get_Username(1, 1).toString();
			emailaddress.sendKeys(emailid);
			continuebutton.click();
			String passwd = xs.get_password(2, 1).toString();
			password.sendKeys(passwd);
			signin.click();
			Reusableclass rc = new Reusableclass(driver);
			rc.innerTextEquals(yoursorder, yoursorder.getText());
			orders.click();
			
			dropdown.click();
			year.click();
			rc.elementAvailable(orderplacedBox, true);
			System.out.println("testcase10------> executed successfully");

		} catch (Exception e) {
			System.out.println("exception ocured while checking returns");
		}
	}
}
