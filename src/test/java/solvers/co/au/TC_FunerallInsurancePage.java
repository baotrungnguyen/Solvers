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
public class TC_FunerallInsurancePage extends DriverFactory {
	public static final Logger logger = LogManager.getLogger("Result");
	@Video
	@Test
	@Parameters({"waitTime", "urlfunerallInsurance"})
	public void TC_Insurance (int waitime, String url) throws Exception {
		WebDriver driver=getDriver();
		driver.get(url);
		WebElementSuport.openBrowserFullScreen(driver);
		Boolean checkURL = WebElementSuport.forWaitURL(driver, url, waitime);
		if (checkURL) {
		FuneralInsurancePage funerallpage=new FuneralInsurancePage(driver);
		

		// check buttons
		logger.info("Click the any button is: "+WebElementSuport.Result(funerallpage.CheckBtn_i(0)));
		logger.info("Click the any button is: "+WebElementSuport.Result(funerallpage.CheckBtn_i(1)));
		logger.info("Click the any button is: "+WebElementSuport.Result(funerallpage.CheckBtn_i(2)));
		logger.info("Click the any button is: "+WebElementSuport.Result(funerallpage.CheckBtn_i(3)));



		
		}else {
			logger.info("This web can not load");
		}
		
		
		
		
	}
	
}
