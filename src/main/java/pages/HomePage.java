package pages;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private Eyes eyes;

    private By filterIcon = By.id("ti-filter");
    private By blackShoesCheckbox = By.id("SPAN__checkmark__107");
    private By filterButton = By.id("filterBtn");
    public By productGrid = By.id("product_grid");
    public By appliAirXNightShoe = By.xpath(".//h3[text()='Appli Air x Night']");



    public HomePage(WebDriver driver){
        this.driver = driver;
        eyes = new Eyes();
    }

    public void clickFilterBlackShoeCheckbox(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(blackShoesCheckbox));
        driver.findElement(blackShoesCheckbox).click();
    }

    public boolean clickFilterIcon() {
        boolean result = false;
        try {
            driver.findElement(filterIcon).click();
            result = false;
        } catch (NoSuchElementException e) {
            result = true;
        } catch (ElementNotInteractableException e) {
            result = true;
        }

        finally
        {
            // close
        }
        return result;
    }


    public void clickFilterButton(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(filterButton));
        driver.findElement(filterButton).click();
    }

    public ProductDetailsPage clickAppliAirXNightShoe(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(appliAirXNightShoe));
        driver.findElement(appliAirXNightShoe).click();
        return new ProductDetailsPage(driver);
    }

    public void waitForProductGridToBePresent(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(productGrid));
    }
}