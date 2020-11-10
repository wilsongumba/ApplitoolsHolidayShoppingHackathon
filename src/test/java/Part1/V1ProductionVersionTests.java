package Part1;

import base.Base;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.fluent.Target;
import org.testng.annotations.Test;

public class V1ProductionVersionTests extends Base {

    @Test(priority = 0)
    public void mainPageTest() {
        Configuration testConfig = eyes.getConfiguration();
        testConfig.setTestName("Test 1");
        eyes.setConfiguration(testConfig);
        driver = eyes.open(driver);
        driver.get(v1URL);
        eyes.check(Target.window().fully().withName("main page"));
    }

    @Test(priority = 1)
    public void filteredProductGridTest() {
        Configuration testConfig = eyes.getConfiguration();
        testConfig.setTestName("Test 2");
        eyes.setConfiguration(testConfig);
        driver = eyes.open(driver);
        driver.get(v1URL);
        homePage.clickFilterIcon();
        homePage.clickFilterBlackShoeCheckbox();
        homePage.clickFilterButton();
        homePage.waitForProductGridToBePresent();
        eyes.check("filter by color", Target.region(homePage.productGrid));
    }

    @Test(priority = 2)
    public void productDetailsTest() {
        Configuration testConfig = eyes.getConfiguration();
        testConfig.setTestName("Test 3");
        eyes.setConfiguration(testConfig);
        driver = eyes.open(driver);
        driver.get(v1URL);
        homePage.clickAppliAirXNightShoe();
        eyes.check(Target.window().fully().withName("“product details"));

    }

}