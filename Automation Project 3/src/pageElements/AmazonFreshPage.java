package pageElements;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class AmazonFreshPage extends AbstractMethods {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public AmazonFreshPage(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(xpath="//a[@data-csa-c-id='6och5c-uafcp6-hsftlj-x40rwq']")WebElement amazonFresh;
	
	@FindBy(xpath="//img[@alt='SHOP']")WebElement shopbycategory;
	
    @FindBy(xpath="//img[@alt='RICE']")WebElement selectRiceanddal;
	
	@FindBy(xpath="(//div[@class='_alm-carousel-desktop_imageStyle_asinBackgroundOverlay__3Pz90'])[1]")WebElement selectDal;
	
	@FindBy(id="a-autoid-0-announce")WebElement signin;
	
    @FindBy(xpath="(//input[@class='a-button-input'])[3]")WebElement addtocartbutton;
	
	@FindBy(xpath="//a[@class='nav-a nav-a-2 nav-progressive-attribute']")WebElement cart;
	
    @FindBy(xpath="(//span[@class='a-truncate-cut'])[1]")WebElement itemsincart;
	
    @FindBy(xpath="(//input[@class='a-button-input'])[1]")WebElement proceedtoBuy;
	
    @FindBy(xpath="(//a[text()='Continue'])[1]")WebElement continuebutton;
    
    @FindBy(xpath="(//input[@class='a-button-input'])[4]")WebElement timeslot;
    
    @FindBy(xpath="//div[@class='a-column a-span8']")WebElement checkout;
    
    @FindBy(xpath="(//div[@class='a-column a-span2'])[1]")WebElement amazonin;
    
    @FindBy(xpath="(//a[@class='a-button-text'])[1]")WebElement returntocart;
        
    @FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") WebElement hoveraccountlist ;
	
	@FindBy(xpath="//span[text()='Sign Out']") WebElement signout ;
    
	public void amazonFresh_checkoutitems() throws IOException {
		implicitlywaitmethod();
		try {
			amazonFresh.click();
			Reusableclass rc = new Reusableclass(driver);
			rc.innerTextEquals(shopbycategory, shopbycategory.getText());
			selectRiceanddal.click();
			selectDal.click();
			signin.click();

			SignInOutPage sp = new SignInOutPage(driver);
			sp.signin();

			addtocartbutton.click();
			cart.click();
			String items = itemsincart.getText();
			rc.innerTextEquals(itemsincart, items);
			proceedtoBuy.click();

			continuebutton.click();
			timeslot.click();
			rc.innerTextEquals(checkout, "Checkout");
			amazonin.click();
			returntocart.click();
		
			Hoveranyelement(hoveraccountlist);
			signout.click();
			
			System.out.println("testcase13------> executed successfully");
		}

		catch (Exception e) {
			System.out.println("Exception occured in testcase13 execution");
		}
	}

}
