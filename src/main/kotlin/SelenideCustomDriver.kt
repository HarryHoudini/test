import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.WebDriverRunner
import config.driver.DriverConfigProvider
import config.environment.EnvironmentConfigurationHolder
import driver.SelenideDriverFactoryManager
import org.apache.logging.log4j.LogManager
import org.openqa.selenium.WebDriver

object SelenideCustomDriver {
  private val driverConfiguration = DriverConfigProvider.getConfiguration()
  private val logger = LogManager.getLogger(this.javaClass.name)

  fun getDriver(): WebDriver {
    return WebDriverRunner.getWebDriver()
  }

  fun configureDriver() {
    logger.info("Configuring driver")
    SelenideDriverFactoryManager.getDriverFactory(driverConfiguration).getDriver()
  }

  fun quit() {
    logger.info("Quit driver")
    getDriver().quit()
  }

  fun authorize() {
    open(EnvironmentConfigurationHolder.environmentConfiguration.getBaseUrlForAuthorisation())
  }
}