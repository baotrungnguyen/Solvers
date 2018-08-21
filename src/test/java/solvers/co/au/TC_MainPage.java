package solvers.co.au;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.WebDriver;
import org.springframework.aop.ThrowsAdvice;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;

import automationCore.DriverFactory;
import support_group.WebElementSuport;

@Listeners(VideoListener.class)
public class TC_MainPage extends DriverFactory {
	public static final Logger logger = LogManager.getLogger("Result");
	@Video
	@Test
	@Parameters({"waitTime", "url"})
	public void TC_MainPage (int waitime, String url) throws Exception {
		WebDriver driver=getDriver();
		driver.get(url);
		WebElementSuport.openBrowserFullScreen(driver);
		Boolean checkURL = WebElementSuport.forWaitURL(driver, url, waitime);
		if (checkURL) {
		HomeSolversPage homesolverpage= new HomeSolversPage(driver);		

		// check buttons

		logger.info("Button Insurance is: "+WebElementSuport.Result(homesolverpage.CheckInsurance()));
		logger.info("Button Finance is: "+WebElementSuport.Result(homesolverpage.CheckFinance()));
		logger.info("Button Carrer: "+WebElementSuport.Result(homesolverpage.CheckCarrer()));
		logger.info("Button Property: "+WebElementSuport.Result(homesolverpage.CheckProperty()));
		logger.info("Button Articles: "+WebElementSuport.Result(homesolverpage.CheckArticles()));
		homesolverpage.InputSubscribe("test", "test", "test@test.com");
		logger.info("Subscribe: "+WebElementSuport.Result(homesolverpage.VerifySucces()));
		WebElementSuport.ClickBackBrowserChrome(driver);
		
		
		}else {
			logger.info("This web can not load");
		}
		
		
		
		
	}
	
}
