package pageElements;

import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class Addtowishlist extends AbstractMethods {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public Addtowishlist(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(id="nav-hamburger-menu") WebElement hamburgerclick;
	
	@FindBy(xpath="//div[text()='Audible Audiobooks']/parent::a") WebElement audiobooks;
	By audio_books = By.xpath("//div[text()='Audible Audiobooks']/parent::a");
	
	@FindBy(xpath="//*[@id=\"hmenu-content\"]/ul[23]/li[6]/a") WebElement audiobooknewReleases ;
	By audiobooks_newReleases = By.xpath("//*[@id=\"hmenu-content\"]/ul[23]/li[6]/a");
	
	@FindBy(xpath="//input[@id='add-to-wishlist-button-submit']") WebElement wishlistadd ;
	
	@FindBy(xpath="(//a[text()='Audible Membership'])[1]") WebElement audiblemembership ;
	
	@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]") WebElement firstaudiobook ;
	By first_audiobook  = By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]");
	
	@FindBy(xpath="(//input[@class='a-button-input'])[5]") WebElement tryforfreebutton ;
	
	@FindBy(xpath="//a[text()=' Add to Wish List ']") WebElement addtowishlist ;	

	@FindBy(xpath="//a[text()='View Your List']") WebElement viewyourlist ;
	
	@FindBy(xpath="//a[@id='itemName_ILFH3M7C3QM9Q']") WebElement iteminthelist ;
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") WebElement hoveraccountlist ;
	
	@FindBy(xpath="//span[text()='Sign Out']") WebElement signout ;
	
	@FindBy(xpath="(//input[@name='submit.add-to-registry.wishlist'])[2]") WebElement wishlistdropdown ;
	
	@FindBy(xpath="//span[@class='a-size-small atwl-hz-vertical-align-middle']") WebElement createwishlist ;
	
	@FindBy(xpath="//input[@id='list-name']") WebElement listname ;
	
	@FindBy(xpath="//*[@id=\"wl-redesigned-create-list\"]/span/span/input") WebElement createlist ;
	
	@FindBy(xpath="//a[text()='View Wish List']") WebElement viewlist ;
	
	public void addtowishlist() throws InterruptedException {
		implicitlywaitmethod();

		try {
		hamburgerclick.click();
		Wait_Till_Link_Is_Clickable(audio_books);
		audiobooks.click();
		Wait_Till_Link_Is_Clickable(audiobooks_newReleases);
		audiobooknewReleases.click();
		Wait_Till_Link_Is_Clickable(first_audiobook);;
		firstaudiobook.click();

		Set<String> handles = driver.getWindowHandles();
		for (String st : handles) {
			driver.switchTo().window(st);
			String url = driver.getCurrentUrl();

			if (url.contains("https://www.amazon.in/Breaking-Mould-Reimagining-Indias")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", tryforfreebutton);

				addtowishlist.click();
				SignInOutPage sn = new SignInOutPage(driver);
				sn.signin();
				js.executeScript("arguments[0].scrollIntoView();", tryforfreebutton);
				wishlistadd.click();
				viewyourlist.click();
				String itemname = iteminthelist.getText();
				Reusableclass rc = new Reusableclass(driver);
				rc.innerTextEquals(iteminthelist, itemname);
				Hoveranyelement(hoveraccountlist);
				signout.click();
				driver.close();
				break;
			}
		}
        System.out.println("testcase3------> executed successfully");
		
		} catch (Exception e) {
			System.out.println("Exception occured in testcase3 execution");
		}
	}
	
	
	public void createnewwishlist() {
		implicitlywaitmethod();

		try {
		hamburgerclick.click();
		Wait_Till_Link_Is_Clickable(audio_books);
		audiobooks.click();
		Wait_Till_Link_Is_Clickable(audiobooks_newReleases);
		audiobooknewReleases.click();
		Wait_Till_Link_Is_Clickable(first_audiobook);;
		firstaudiobook.click();

		Set<String> handles = driver.getWindowHandles();
		for (String st : handles) {
			driver.switchTo().window(st);
			String url = driver.getCurrentUrl();

			if (url.contains("https://www.amazon.in/Breaking-Mould-Reimagining-Indias")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", tryforfreebutton);

				addtowishlist.click();
				SignInOutPage sn = new SignInOutPage(driver);
				sn.signin();
				js.executeScript("arguments[0].scrollIntoView();", tryforfreebutton);
				wishlistdropdown.click();
				createwishlist.click();
				createlist.click();
				
				viewlist.click();
				String itemname = iteminthelist.getText();
				Reusableclass rc = new Reusableclass(driver);
				rc.innerTextEquals(iteminthelist, itemname);
				Hoveranyelement(hoveraccountlist);
				signout.click();
				driver.close();
			}
		}
        System.out.println("testcase4------> executed successfully");
		
		} catch (Exception e) {
			System.out.println("Exception occured in testcase4 execution");
		}
	}
}