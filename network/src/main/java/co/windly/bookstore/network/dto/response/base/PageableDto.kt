package co.windly.bookstore.network.dto.response.base

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PageableDto<T>(

  @get:JsonProperty("next")
  var next: String? = null,

  @get:JsonProperty("previous")
  var previous: String? = null,

  @get:JsonProperty("results")
  var results: List<T> = mutableListOf()
)
