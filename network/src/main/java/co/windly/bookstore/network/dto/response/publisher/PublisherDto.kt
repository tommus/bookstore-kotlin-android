package co.windly.bookstore.network.dto.response.publisher

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class PublisherDto(

  @get:JsonProperty("id")
  var id: Long = 0L,

  @get:JsonProperty("name")
  var name: String = ""
)
