package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
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

public class BuyItemsPage extends AbstractMethods {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public BuyItemsPage(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]") WebElement selectedbook;
	
	@FindBy(id="twotabsearchtextbox") WebElement searchtextbox;
	
	@FindBy(xpath="(//span[@class='a-button-text a-declarative'])[3]")WebElement quantity;
	
	@FindBy(xpath="(//i[@class='a-icon a-icon-checkbox'])[3]") WebElement deliveryday ;
    
    @FindBy(xpath="//*[@id=\"p_72-title\"]/span")WebElement customerreviews;
	
	@FindBy(xpath="//*[@id=\"p_72/1318476031\"]/span/a/section/i]") WebElement customerratings ;
	
	@FindBy(xpath="(//span[@class='a-size-base a-color-base'])[19]") WebElement price ;
	
	@FindBy(id="high-price") WebElement maxprice;

	@FindBy(xpath="(//input[@class='a-button-input'])[2]") WebElement pricego;
	
	@FindBy(xpath="(//span[@class='a-size-base a-color-base puis-bold-weight-text'])[13]")WebElement discount;
	
	@FindBy(xpath="(//span[@class='a-size-base a-color-base'])[66]") WebElement discoutoff;
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") WebElement hoveraccountlist ;
	
	@FindBy(xpath="//span[text()='Sign Out']") WebElement signout ;
	
	@FindBy(xpath="//span[@class='a-size-medium-plus a-color-base a-text-bold']") WebElement resultpage;
	
	@FindBy(id="buy-now-button")WebElement buynow;
	
	@FindBy(xpath="//div[@class='a-column a-span8']")WebElement checkout;
	
	@FindBy(xpath="(//input[@class='a-button-input'])[6]")WebElement useaddressbutton;
	
    @FindBy(xpath="(//div[@class='a-column a-span2'])[1]")WebElement amazonin;
    
    @FindBy(xpath="(//a[@class='a-button-text'])[1]")WebElement returntocart;
    
	public void buyproducts() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    try {
	    	
	    	SignInOutPage sp = new SignInOutPage(driver);
			sp.signin();
			searchtextbox.click();
			String Search_item = prop.getProperty("Search_item");
			searchtextbox.sendKeys(Search_item);
			
			deliveryday.click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", customerreviews);
			customerratings.click();
			
			price.click();
			String MaxPrice = prop.getProperty("MaxPrice");
			maxprice.sendKeys(MaxPrice);
			pricego.click();
			
			js.executeScript("arguments[0].scrollIntoView();", discount);
			discoutoff.click();
			
			Reusableclass rc= new Reusableclass(driver);
			rc.innerTextEquals(resultpage,"Results");
			
			String book = selectedbook.getText();
			rc.innerTextEquals(selectedbook,book);
	    	selectedbook.click();
	    	
	    	Set<String> handles = driver.getWindowHandles();
			for(String st: handles) {
				driver.switchTo().window(st);
				String url=driver.getCurrentUrl();
				
				if(url.contains("https://www.amazon.in/Dont-Believe")) {
					js.executeScript("arguments[0].scrollIntoView();", quantity);
					buynow.click();
					rc.elementAvailable(checkout,true);
					useaddressbutton.click();
					
					amazonin.click();
					returntocart.click();
				
					Hoveranyelement(hoveraccountlist);
					signout.click();
					break;
				}
			}				    	
	    		    	
	    	System.out.println("testcase20------> executed successfully");
		} catch (Exception e) {
			System.out.println("Exception occured in testcase20 execution");
		}
		}
}
