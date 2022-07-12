package driver;

import org.openqa.selenium.WebDriver;

import static driver.DriverSetup.localChrome;
import static driver.DriverSetup.localFirefox;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class DriverFactory {
  private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  private DriverFactory() {}

  public static synchronized WebDriver getDriver() {
    if (driver.get() == null || driver.get().toString().contains("(null)")) {
      setWebDriver(chooseDriver());
    }
    return driver.get();
  }

  private static synchronized void setWebDriver(WebDriver driver) {
    DriverFactory.driver.set(driver);
  }

  private static synchronized WebDriver chooseDriver() {
    if (System.getProperty("browser") == null) {
      return localChrome();
    } else {
      switch (System.getProperty("browser")) {
        case FIREFOX:
          return localFirefox();
        case CHROME:
          return localChrome();
        default:
          throw new IllegalArgumentException("Unsupported browser.");
      }
    }
  }
}
