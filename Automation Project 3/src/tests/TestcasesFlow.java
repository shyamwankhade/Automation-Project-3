package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageElements.AddAdresssPage;
import pageElements.Addtowishlist;
import pageElements.AmazonFreshPage;
import pageElements.AmazonPrimePage;
import pageElements.Amazon_PayPage;
import pageElements.BuyItemsPage;
import pageElements.NewIteams_Releases;
import pageElements.SelectingCountrypage;
import pageElements.SubscriptionsPage;
import pageElements.ReturnsPage;
import pageElements.Scrollupdown_funtionality;
import pageElements.SearchItems;

public class TestcasesFlow {
	WebDriver driver;

	SelectingCountrypage sc;
	Addtowishlist al;
	Amazon_PayPage am;
	SubscriptionsPage sp;
	ReturnsPage rp;
	AddAdresssPage ad;
	AmazonFreshPage af;
	AmazonPrimePage ap;
	NewIteams_Releases nr;
	Scrollupdown_funtionality sf;
	SearchItems si;
	BuyItemsPage bi;

	@BeforeTest
	public void setup() throws IOException {
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(); // intializing
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver(); // intializing
		}
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void language_select() {
		sc = new SelectingCountrypage(driver);
		sc.languageselect();
	}

	@Test(priority = 2)
	public void select_country() {
		sc = new SelectingCountrypage(driver);
		sc.country_select();
	}

	@Test(priority = 3)
	public void add_items_to_wishlist() throws InterruptedException {
		al = new Addtowishlist(driver);
		al.addtowishlist();
	}

	@Test(priority = 4)
	public void create_wishlist() throws InterruptedException {
		al = new Addtowishlist(driver);
		al.createnewwishlist();
	}

	@Test(priority = 5)
	public void amazonpay_rewards() throws InterruptedException {
		am = new Amazon_PayPage(driver);
		am.amazonpayrewards();
	}

	@Test(priority = 6)
	public void amazonpay_mobilerecharge() throws InterruptedException, IOException {
		am = new Amazon_PayPage(driver);
		am.mobilerecharge();
	}

	@Test(priority = 7)
	public void subscription_mail() throws InterruptedException, IOException {
		sp = new SubscriptionsPage(driver);
		sp.subscriptionmail();
	}

	@Test(priority = 8)
	public void membership_subscriptions() throws InterruptedException, IOException {
		sp = new SubscriptionsPage(driver);
		sp.membershipsubscriptions();
	}

	@Test(priority = 9)
	public void returns_Page_items() throws InterruptedException, IOException {
		rp = new ReturnsPage(driver);
		rp.returns_items();
	}

	@Test(priority = 10)
	public void returns_and_orders() throws InterruptedException, IOException {
		rp = new ReturnsPage(driver);
		rp.returns_items();
	}

	@Test(priority = 11)
	public void amazonpay_travel() throws InterruptedException, IOException {
		am = new Amazon_PayPage(driver);
		am.amazonpaytravel();
	}

	@Test(priority = 12)
	public void add_new_Address() throws InterruptedException, IOException {
		ad = new AddAdresssPage(driver);
		ad.addaddress();
	}

	@Test(priority = 13)
	public void checkout_items_in_AmazonFresh() throws InterruptedException, IOException {
		af = new AmazonFreshPage(driver);
		af.amazonFresh_checkoutitems();
	}

	@Test(priority = 14)
	public void check_amazon_prime() throws InterruptedException, IOException {
		ap = new AmazonPrimePage(driver);
		ap.amazonprime();
	}

	@Test(priority = 15)
	public void newIteams_Releases_checkout() throws InterruptedException, IOException {
		nr = new NewIteams_Releases(driver);
		nr.newreleases();
	}

	@Test(priority = 16)
	public void scrollupdown_funtionality_using_backtotobutton() throws InterruptedException, IOException {
		sf = new Scrollupdown_funtionality(driver);
		sf.scrollupdown_using_backtotopbutton();
	}

	@Test(priority = 17)
	public void scrollupdown_funtionality_without_using_backtotobutton() throws InterruptedException, IOException {
		sf = new Scrollupdown_funtionality(driver);
		sf.scrollupdown_withoutusingbutton();
	}

	@Test(priority = 18)
	public void searchItems_based_on_category() throws InterruptedException, IOException {
		si = new SearchItems(driver);
		si.searchiteams_category();
	}

	@Test(priority = 19)
	public void searchItems_based_on_discountanddelivery() throws InterruptedException, IOException {
		si = new SearchItems(driver);
		si.searchitems_discountanddelivery();
	}

	@Test(priority = 20)
	public void buyItems() throws InterruptedException, IOException {
		bi = new BuyItemsPage(driver);
		bi.buyproducts();
	}
}
