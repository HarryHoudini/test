package utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

fun transformDataToJson(data: Any): String =
  ObjectMapper().registerModule(KotlinModule()).writeValueAsString(data)