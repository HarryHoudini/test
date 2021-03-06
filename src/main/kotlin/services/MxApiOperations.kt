package services

import api.client.CustomClient
import api.client.data.CookieType
import api.generator.CrmRequestGenerator
import config.environment.EnvironmentConfiguration
import config.environment.EnvironmentConfigurationHolder
import context.DynamicContextHolder

class MxApiOperations(private val envConfig: EnvironmentConfiguration = EnvironmentConfigurationHolder.configuration) {
  fun createAuthorizationSession() {
    val crmResponse = CustomClient.sendRequest(
      CrmRequestGenerator(envConfig).getAuthorizeCrmRequest()
    )
    DynamicContextHolder.dynamicContext.addSessionCookies(
      crmResponse.getCookies().filter { entry -> entry.key == CookieType.JSESSIONID.text })
  }
}