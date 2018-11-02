package co.windly.bookstore.network.dto.response.binding

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BindingDto(

  @get:JsonProperty("id")
  var id: Long = 0L,

  @get:JsonProperty("description")
  var description: String = ""
)
