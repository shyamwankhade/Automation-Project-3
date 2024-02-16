package pageElements;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class AmazonPrimePage extends AbstractMethods {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public AmazonPrimePage(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(id="nav-link-amazonprime")WebElement amazonPrime;
	
    @FindBy(id="multiasins-img-link")WebElement joinprime;
	
	@FindBy(xpath="//a[text()='Login to join Prime']")WebElement logintojoinprime;
	
	@FindBy(id="primeLogo")WebElement primelogo;
	
    @FindBy(xpath="//a[text()='Amazon Prime Terms and Conditions']")WebElement primeconditions;
	
	@FindBy(xpath=" //h2[text()=' Explore all Prime benefits ']")WebElement explorebenifits;

    @FindBy(xpath="//a[text()='here']")WebElement clickhere;
	
    @FindBy(xpath="(//div[@class='a-box-inner'])[1]")WebElement benifitsbox;
	
    @FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") WebElement hoveraccountlist ;
	
	@FindBy(xpath="//span[text()='Sign Out']") WebElement signout ;
	
	public void amazonprime() throws IOException {
		implicitlywaitmethod();
		try {
			amazonPrime.click();
			joinprime.click();
			logintojoinprime.click();

			SignInOutPage sp = new SignInOutPage(driver);
			sp.signin();

			Reusableclass rc = new Reusableclass(driver);
			rc.innerTextEquals(primelogo, "prime");

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", explorebenifits);

			primeconditions.click();
			clickhere.click();
			Set<String> handles = driver.getWindowHandles();
			for (String st : handles) {
				driver.switchTo().window(st);
				String url = driver.getCurrentUrl();

				if (url.contains("https://www.amazon.in/gp/primecentral")) {
					rc.elementAvailable(benifitsbox, true);
					
					driver.close();
					break;
				}
			}
			Hoveranyelement(hoveraccountlist);
			signout.click();

			System.out.println("testcase14------> executed successfully");
		}

		catch (Exception e) {
			System.out.println("Exception occured in testcase14 execution");
		}
	}
}
