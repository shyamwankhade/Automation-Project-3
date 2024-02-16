package pageElements;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class NewIteams_Releases extends AbstractMethods {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public NewIteams_Releases(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

    @FindBy(id="3tw3kq-9l2qn4-bpujna-qtrh9r")WebElement newreleases;
	
    @FindBy(xpath="(//a[text()='Books'])[2]")WebElement books;
	
	@FindBy(xpath="(//div[@class='_cDEzb_p13n-sc-css-line-clamp-1_1Fn1y'])[1]")WebElement firstbookrelease;
	
	@FindBy(id="a-autoid-3-announce")WebElement quantity;
	
    @FindBy(id="quantity_1")WebElement secondQuantity;
	
	@FindBy(xpath="(//input[@id='add-to-cart-button'])[1]")WebElement addtocart;

    @FindBy(xpath="//div[@class='a-section a-padding-medium sw-atc-message-section']")WebElement addedtocarttext;
	
    @FindBy(xpath="//input[@name='proceedToRetailCheckout']")WebElement proceedtocheckout;
	
    @FindBy(xpath="//div[@class='a-column a-span8']")WebElement checkout;
    
    @FindBy(xpath="(//div[@class='a-column a-span2'])[1]")WebElement amazonin;
    
    @FindBy(xpath="(//a[@class='a-button-text'])[1]")WebElement returntocart;
        
    @FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") WebElement hoveraccountlist ;
	
	@FindBy(xpath="//span[text()='Sign Out']") WebElement signout ;
	
	public void newreleases() {
		implicitlywaitmethod();
		
		try {
			newreleases.click();
			books.click();
			System.out.println(firstbookrelease.getText());
			firstbookrelease.click();
			quantity.click();
			
			secondQuantity.click();
			addtocart.click();
			Reusableclass rc = new Reusableclass(driver);
			rc.elementAvailable(addedtocarttext, true);
			
			proceedtocheckout.click();
			SignInOutPage sp = new SignInOutPage(driver);
			sp.signin();
			
			rc.innerTextEquals(checkout, "Checkout");
			
			amazonin.click();
			returntocart.click();
		
			Hoveranyelement(hoveraccountlist);
			signout.click();
			System.out.println("testcase15------> executed successfully");
		}

		catch (Exception e) {
			System.out.println("Exception occured in testcase15 execution");
		}
	}
}
