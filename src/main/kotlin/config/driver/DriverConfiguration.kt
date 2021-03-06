package config.driver

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import ui.driver.BrowserType
import ui.driver.selenium.DriverExecutionType

@JsonIgnoreProperties(ignoreUnknown = true)
data class DriverConfiguration(
  var browserType: BrowserType,
  var driverExecutionType: DriverExecutionType,
  var chromeVersion: String,
  var firefoxVersion: String,
  var hubUrl: String,
  var implicitlyDefaultTimeoutSeconds: Long,
  var pageLoadedDefaultTimeoutSeconds: Long,
  var scriptDefaultTimeoutSeconds: Long,
  var timeoutSeconds: Long,
  var windowHeight: Int,
  var windowWidth: Int,
  var headless: Boolean
)