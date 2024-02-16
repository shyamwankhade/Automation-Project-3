package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class SearchItems extends AbstractMethods {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public SearchItems(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	    @FindBy(id="twotabsearchtextbox") WebElement searchtextbox;
		
		@FindBy(xpath="(//div[@class='s-suggestion discover-tr-suggestion'])[2]") WebElement applyingprice;
		
	    @FindBy(xpath="(//span[@class='a-size-base a-color-base'])[10]") WebElement category	 ;
		
		@FindBy(xpath="(//*[@class='a-size-base a-color-base'])[11]") WebElement childrencategory ;
		
		@FindBy(xpath="(//span[@class='a-size-base a-color-base puis-bold-weight-text'])[9]") WebElement booktype ;
		
		@FindBy(xpath="(//i[@class='a-icon a-icon-checkbox'])[6]") WebElement picturebook ;
		
		@FindBy(xpath="(//i[@class='a-icon a-icon-checkbox'])[9]") WebElement kindlebooks ;
		
		@FindBy(xpath="(//span[@class='a-size-base a-color-base puis-bold-weight-text'])[5]") WebElement language ;
		
		@FindBy(xpath="(//i[@class='a-icon a-icon-checkbox'])[1]") WebElement englishLanguage;

		@FindBy(xpath="//span[@class='a-size-medium-plus a-color-base a-text-bold']") WebElement resultpage;
		
		@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")WebElement firstbook;
		
		
        @FindBy(xpath="(//i[@class='a-icon a-icon-checkbox'])[3]") WebElement deliveryday ;
        
        @FindBy(xpath="//*[@id=\"p_72-title\"]/span")WebElement customerreviews;
		
		@FindBy(xpath="//*[@id=\"p_72/1318476031\"]/span/a/section/i]") WebElement customerratings ;
		
		@FindBy(xpath="(//span[@class='a-size-base a-color-base'])[19]") WebElement price ;
		
		@FindBy(id="high-price") WebElement maxprice;

		@FindBy(xpath="(//input[@class='a-button-input'])[2]") WebElement pricego;
		
		@FindBy(xpath="(//span[@class='a-size-base a-color-base puis-bold-weight-text'])[13]")WebElement discount;
		
		@FindBy(xpath="(//span[@class='a-size-base a-color-base'])[66]") WebElement discoutoff;

		@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]") WebElement selectedbook;
		
		@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") WebElement hoveraccountlist ;
		
		@FindBy(xpath="//span[text()='Sign Out']") WebElement signout ;
		
		public void searchiteams_category() throws IOException {
		
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
				
				category.click();
				childrencategory.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", booktype);
				picturebook.click();
				
				js.executeScript("arguments[0].scrollIntoView();", booktype);
				kindlebooks.click();
				js.executeScript("arguments[0].scrollIntoView();", language);
				englishLanguage.click();
				
				Reusableclass rc= new Reusableclass(driver);
				rc.innerTextEquals(resultpage,"Results");
				
				System.out.println(firstbook.getText());
				Hoveranyelement(hoveraccountlist);
				signout.click();
				System.out.println("testcase18------> executed successfully");
			} catch (Exception e) {
				System.out.println("Exception occured in testcase18 execution");
			}
			}
	
		
		public void searchitems_discountanddelivery() throws IOException {
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
				Hoveranyelement(hoveraccountlist);
				signout.click();
				
				System.out.println("testcase19------> executed successfully");
			} catch (Exception e) {
				System.out.println("Exception occured in testcase19 execution");
			}
			}
		
		
}
