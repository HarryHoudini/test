package api.client

import api.client.data.HttpMethod

class CustomRequest private constructor(
  var url: String,
  var method: HttpMethod,
  var headers: Map<String, List<String>> = HashMap(),
  var body: Any? = null,
  var credentials: Credentials? = null
) {

  data class Builder(
    var url: String,
    var method: HttpMethod,
    var headers: MutableMap<String, MutableList<String>> = HashMap(),
    var body: Any? = null,
    var credentials: Credentials? = null
  ) {

    fun addHeader(name: String, value: String) = apply {
      if (headers.contains(name)) {
        headers[name]?.add(value) ?: headers.put(name, mutableListOf(value))
      } else {
        headers[name] = mutableListOf(value)
      }
    }

    fun body(body: Any) = apply { this.body = body }
    fun credentials(credentials: Credentials) = apply { this.credentials = credentials }
    fun build() = CustomRequest(url, method, headers, body, credentials)
  }
}

data class Credentials(val username: String, val password: String)