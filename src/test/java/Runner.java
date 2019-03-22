import com.epam.testng.JIRATestNGListener;
import org.testng.IReporter;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.addListener((ITestNGListener) new JIRATestNGListener());

        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setSuiteFiles(Arrays.asList("D:\\data\\adapterjavatestngdemo\\src\\test\\resources\\testng.xml"));

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(xmlSuite);

        testNG.setXmlSuites(suites);
        testNG.run();
    }
}
