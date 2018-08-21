package automationCore;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class GenerateReport extends TestListenerAdapter {
	
	private Document  loadReportTemplate() throws Exception {
	       File htmlFile = new File(System.getProperty("user.dir")+ File.separator + "data" + File.separator + "reportTemplate" + File.separator + "report1.html");
	       Document doc = Jsoup.parse(htmlFile, "UTF-8");
	       return doc;
	}
	
	
	@Override
	public void onTestFailure (ITestResult failingTest) {
		   Document doc;
		   String testName = failingTest.getName();
		   long testDateLong = failingTest.getStartMillis();
		   Date testDateString = new Date(testDateLong);
		try {
			doc = loadReportTemplate();
		       String title = doc.title();
		       System.out.println("Title : " + title);
		       Element result_table = doc.getElementById("result_table");
		       result_table.append("<tr class='danger'><td>" + testName + "</td><td>FAILED</td><td>" + testDateString+"</td></tr>");
		        final File f = new File(System.getProperty("user.dir")+ File.separator + "data" + File.separator + "reportTemplate" + File.separator + "report1.html");
		        FileUtils.writeStringToFile(f, doc.outerHtml(), "UTF-8");
		} catch (Exception e) {
			System.out.println("UNABLE TO READ TEMPLATE");
			e.printStackTrace();
		}


	}
	
	@Override
	public void onTestSuccess (ITestResult successTest) {
		   Document doc;
		   String testName = successTest.getName();
		   long testDateLong = successTest.getStartMillis();
		   Date testDateString = new Date(testDateLong);
		try {
			doc = loadReportTemplate();
		       String title = doc.title();
		       System.out.println("Title : " + title);
		       Element result_table = doc.getElementById("result_table");
		       result_table.append("<tr class='success'><td>" + testName + "</td><td>PASSED</td><td>" + testDateString+"</td></tr>");
		        final File f = new File(System.getProperty("user.dir")+ File.separator + "data" + File.separator + "reportTemplate" + File.separator + "report1.html");
		        FileUtils.writeStringToFile(f, doc.outerHtml(), "UTF-8");
		} catch (Exception e) {
			System.out.println("UNABLE TO READ TEMPLATE");
			e.printStackTrace();
		}

	}
	@Override
	public void onTestSkipped (ITestResult skippedTest) {
		   Document doc;
		   String testName = skippedTest.getName();
		   long testDateLong = skippedTest.getStartMillis();
		   Date testDateString = new Date(testDateLong);
		try {
			doc = loadReportTemplate();
		       String title = doc.title();
		       System.out.println("Title : " + title);
		       Element result_table = doc.getElementById("result_table");
		       result_table.append("<tr class='warning'><td>" + testName + "</td><td>SKIPPED</td><td>" + testDateString+"</td></tr>");
		        final File f = new File(System.getProperty("user.dir")+ File.separator + "data" + File.separator + "reportTemplate" + File.separator + "report1.html");
		        FileUtils.writeStringToFile(f, doc.outerHtml(), "UTF-8");
		} catch (Exception e) {
			System.out.println("UNABLE TO READ TEMPLATE");
			e.printStackTrace();
		}
	}

}
