package automationCore;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class TestCreate implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation testannotation, Class testClass,
		Constructor testConstructor, Method testMethod)	{
		final String dataFile = System.getProperty("dataFile","");
		final String dataSheet = System.getProperty("dataSheet","");
		if (!dataFile.equals("") & !dataSheet.equals("")) {
			final Object [][] arrayObject = ReadExcel.getExcelData(System.getProperty("user.dir")+ File.separator + "data" + File.separator + dataFile,dataSheet);
			for (int i = 0; i < arrayObject.length; i++) {
				if (arrayObject[i][3].toString().toLowerCase().equals("n")) {
				    if (arrayObject[i][1].equals(testMethod.getName())) {
				    	System.out.println("SKIP TEST : " + testMethod.getName());
					      testannotation.setEnabled(false);
					    }
				}
			}
		}

	}
}
