package helpers;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class CommonUtils {
  public static WebDriver getDriver() {
    return DriverFactory.getDriver();
  }

  public static WebDriverWait getWait() {
    return new WebDriverWait(getDriver(), 20);
  }

  public static WebElement getElement(By locator) {
    return getDriver().findElement(locator);
  }

  public static List<WebElement> getElements(By locator) {
    return getDriver().findElements(locator);
  }

  public static By byTag(String name) {
    return By.tagName(name);
  }

  public static By byClass(String name) {
    return By.className(name);
  }

  public static By byId(String name) {
    return By.id(name);
  }

  public static By byName(String name) {
    return By.name(name);
  }

  public static By byXpath(String name) {
    return By.xpath(name);
  }

  public static By byCss(String name) {
    return By.cssSelector(name);
  }

  public static void click(By locator) {
    getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
  }

  public static void waitForElementClickable(By locator) {
    getWait().until(ExpectedConditions.elementToBeClickable(locator));
  }

  public static void assertText(String text, By locator) {
    getWait().until(ExpectedConditions.textToBe(locator, text));
  }

  public static void assertTextContains(String text, By locator) {
    new WebDriverWait(getDriver(), 45).until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
  }

  public static void assertInputValue(String text, By locator) {
    getWait().until(ExpectedConditions.textToBePresentInElementValue(locator, text));
  }
  public static void waitUntilVisible(By locator) {
    getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public static void waitUntilVisible(By locator, int timeout) {
    new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
  }
  public static void waitUntilElementPresent(By locator) {
    getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  public static void waitUntilNotVisible(By locator) {
    new WebDriverWait(getDriver(), 30).until(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

  public static void waitUntilNotVisible(By locator, int timeout) {
    new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

  public static void waitForUrlToBe(String url) {
    getWait().until(ExpectedConditions.urlToBe(url));
  }

  public static void waitForUrlToBe(String url, int timeout) {
    new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.urlToBe(url));
  }

  public static void type(String text, By locator) {
    getWait().until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
  }

  public static void type(int character, By locator) {
    getWait().until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(String.valueOf(character));
  }

  public static void type(String text, WebElement element) {
    getWait().until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
  }

  public static String getText(By locator) {
    return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
  }

  public static String getText(By locator, int index) {
    return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)).get(index).getText();
  }

  public static void uploadFile(String fileName, By locator) {
    waitUntilElementPresent(locator);
    ClassLoader classLoader = CommonUtils.class.getClassLoader();
    File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
    getElement(locator).sendKeys(file.getAbsolutePath());
  }

  public static boolean isPresent(By locator) {
    return !getElements(locator).isEmpty();
  }

  public static void typeIfEmptyInput(By locator, String text) {
    if (getElement(locator).getAttribute("value").isEmpty()) type(text, locator);
  }
  public static void  checkIfIsDisplayed(By locator){
    getElement(locator).isDisplayed();
  }
  public static void waitForXSeconds(int seconds) {
    try {
      Thread.sleep(seconds * 1000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
      Thread.currentThread().interrupt();
    }
  }
}
