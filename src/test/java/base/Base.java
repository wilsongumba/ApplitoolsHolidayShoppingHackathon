package base;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class Base {

    //strings used
    private String applitoolsEyesServer = "https://eyes.applitools.com/";
    String appName = "AppliFashion";
    public String v1URL = "https://demo.applitools.com/tlcHackathonMasterV1.html";
    public String devURL = "https://demo.applitools.com/tlcHackathonDev.html";
    public String v2URL = "https://demo.applitools.com/tlcHackathonMasterV2.html";
    private String batchName = "Testing Lifecycle";
    private String eyesAPIKey = "iVI9DNZ3FvsADkMkwB80uBVcP7PAoWMXL7Kg103qhumf0110";


    private EyesRunner runner = null;
    private Configuration testConfig;
    protected Eyes eyes;
    protected WebDriver driver;

    protected HomePage homePage;



    @BeforeSuite
    public void setUp() {
        runner = new VisualGridRunner(10);
        testConfig = (Configuration) new Configuration()

                .addBrowser(1200, 800, BrowserType.CHROME)

                .setViewportSize(new RectangleSize(1200, 800))
                .setApiKey(eyesAPIKey)
                .setServerUrl(applitoolsEyesServer)
                .setAppName(appName)
                .setBatch(new BatchInfo(batchName));
    }

    @BeforeMethod
    public void launchApplication() {
        eyes = new Eyes(runner);
        eyes.setConfiguration(testConfig);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        homePage = new HomePage(driver);

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        boolean testFailed = result.getStatus() == ITestResult.FAILURE;
        if (!testFailed) {
            eyes.closeAsync();
        } else {
            eyes.abortAsync();
        }
        driver.quit();

    }

    @AfterSuite
    public void processResults() {

        // we pass false to this method to suppress the exception that is thrown if we
        // find visual differences
        TestResultsSummary allTestResults = runner.getAllTestResults(false);
        System.out.println(allTestResults);
    }


}