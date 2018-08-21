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
public class TC_InsurancePage extends DriverFactory {
	public static final Logger logger = LogManager.getLogger("Result");
	@Video
	@Test
	@Parameters({"waitTime", "urlInsurance"})
	public void TC_Insurance (int waitime, String url) throws Exception {
		WebDriver driver=getDriver();
		driver.get(url);
		WebElementSuport.openBrowserFullScreen(driver);
		Boolean checkURL = WebElementSuport.forWaitURL(driver, url, waitime);
		if (checkURL) {
		InsurancePage insurancepage= new InsurancePage(driver);		

		// check buttons

		
//		logger.info("Button Get A Quote is: "+WebElementSuport.Result(insurancepage.CheckGetAQuote()));		
//		logger.info("Button Find Out More 1 is: "+WebElementSuport.Result(insurancepage.FindOutMore1()));
//		logger.info("Button Find Out More 2 is: "+WebElementSuport.Result(insurancepage.FindOutMore2()));
//		logger.info("Button Find Out More 3 is: "+WebElementSuport.Result(insurancepage.FindOutMore3()));
//		logger.info("Button Find Out More 3 is: "+WebElementSuport.Result(insurancepage.LearnMoreBlog()));
//		logger.info("Button Find Out More 3 is: "+WebElementSuport.Result(insurancepage.LearnMoremedicare()));
//		logger.info("Button Find Out More 3 is: "+WebElementSuport.Result(insurancepage.MoreArticles()));
//		insurancepage.InputForm();
		}else {
			logger.info("This web can not load");
		}
		
		
		
		
	}
	
}
