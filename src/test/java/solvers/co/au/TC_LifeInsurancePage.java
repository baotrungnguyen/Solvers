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
public class TC_LifeInsurancePage extends DriverFactory {
	public static final Logger logger = LogManager.getLogger("Result");
	@Video
	@Test
	@Parameters({"waitTime", "urlLifteInsurance"})
	public void TC_Insurance (int waitime, String url) throws Exception {
		WebDriver driver=getDriver();
		driver.get(url);
		WebElementSuport.openBrowserFullScreen(driver);
		Boolean checkURL = WebElementSuport.forWaitURL(driver, url, waitime);
		if (checkURL) {
		LifeInsurancePage linensurancepage= new LifeInsurancePage(driver);		

		// check buttons

		
		logger.info("Get Start Get A Quote is: "+WebElementSuport.Result(linensurancepage.CheckGetStart()));		
		//logger.info("Get Start Get A Quote is: "+WebElementSuport.Result(linensurancepage.CheckGet_A_Quote()));	
		//logger.info("Get More is: "+WebElementSuport.Result(linensurancepage.Check1More_1()));	
		//logger.info("Get More is: "+WebElementSuport.Result(linensurancepage.Check1More_2()));	
		//logger.info("Get More is: "+WebElementSuport.Result(linensurancepage.Check1More_3()));	

		
		}else {
			logger.info("This web can not load");
		}
		
		
		
		
	}
	
}
