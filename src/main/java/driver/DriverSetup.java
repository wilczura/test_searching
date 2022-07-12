package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;

public class DriverSetup {
  static WebDriver localFirefox() {
    firefoxdriver().setup();
    FirefoxOptions options = new FirefoxOptions();
    return new FirefoxDriver(options);
  }

  static WebDriver localChrome() {
    ChromeOptions options = new ChromeOptions();

    if (System.getProperty("forJenkins") != null) {
      chromedriver().driverVersion("102.0.5005.61").setup();
    } else {
      chromedriver().setup();
    }

    return new ChromeDriver(options);
  }
}
