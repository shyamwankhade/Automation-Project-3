package pageElements;

import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.AbstractMethods;
import utilities.ExcelUtility1;

public class SignInOutPage extends AbstractMethods {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public SignInOutPage(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[text()='Sign in'])[1]")WebElement signinbutton;
	
    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']") WebElement HoverSignIN;
	
	@FindBy(id = "ap_email")WebElement emailaddress;	

	@FindBy(xpath = "//*[@id=\"ap_password\"]")WebElement password;	

	@FindBy(id = "continue")WebElement continuebutton;
	
	@FindBy(id = "signInSubmit")WebElement signin;
	
	@FindBy(xpath="//input[@type='checkbox']") WebElement checkbox;
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") WebElement hoveraccountlist ;
	
	@FindBy(xpath="//span[text()='Sign Out']") WebElement signout ;
	
	public void signin() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		try {

			ExcelUtility1 xs = new ExcelUtility1();

			String emailid = xs.get_Username(1, 1).toString();
			emailaddress.sendKeys(emailid);
			continuebutton.click();
			String passwd = xs.get_password(2, 1).toString();
			password.sendKeys(passwd);
			signin.click();
		} catch (Exception e) {
			System.out.println("Exception in signing in the amzon website");
		}
	}

	public void signout() {
		try {
			Hoveranyelement(hoveraccountlist);
			signout.click();
		} catch (Exception e) {
		}
	}

	public void signup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		try {

			ExcelUtility1 xs = new ExcelUtility1();

			String emailid = xs.get_Username(1, 1).toString();
			emailaddress.sendKeys(emailid);
			String passwd = xs.get_password(2, 1).toString();
			password.sendKeys(passwd);
			signin.click();
		} catch (Exception e) {
			System.out.println("Exception in signing in the amzon website");
		}
	}
}
