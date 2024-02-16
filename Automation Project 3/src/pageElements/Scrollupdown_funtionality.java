package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.AbstractMethods;
import utilities.Reusableclass;

public class Scrollupdown_funtionality extends AbstractMethods {

	WebDriver driver;

	public Scrollupdown_funtionality(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='navFooterBackToTopText']")WebElement backtotopbutton;
	
	@FindBy(xpath="//*[@id=\"navBackToTop\"]/div/span")WebElement backtotoptext;
	
	@FindBy(id="nav-logo-sprites") WebElement amazonlogo;
	
	@FindBy(xpath="//a[@aria-label='Amazon India Home']")WebElement amazonlogobottom;
	
	public void scrollupdown_using_backtotopbutton() throws IOException {
		implicitlywaitmethod();
		

		try {
			Reusableclass rc = new Reusableclass(driver);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", backtotopbutton);
			
			rc.innerTextEquals(backtotoptext, "Back to top");
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.elementToBeClickable(backtotopbutton));
			
			backtotopbutton.click();
			rc.elementAvailable(amazonlogo, true);
			
			System.out.println("Testcase16--> executed succesfully");
			
		} catch (Exception e) {
			System.out.println("Exception occured in testcase16 execution");
		}
	}

	public void scrollupdown_withoutusingbutton() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);

		try {
			Reusableclass rc = new Reusableclass(driver);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", amazonlogobottom);
			
			rc.elementAvailable(amazonlogobottom, true);
			
			js.executeScript("arguments[0].scrollIntoView();", amazonlogo);
			rc.elementAvailable(amazonlogo, true);

			System.out.println("Testcase17--> executed succesfully");
		} catch (Exception e) {
			System.out.println("Exception occured in testcase17 execution");
		}
	}
}