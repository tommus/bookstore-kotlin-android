package co.windly.bookstore.network.dto.response.author

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class AuthorDto(

  @get:JsonProperty("id")
  var id: Long = 0L,

  @get:JsonProperty("first_name")
  var firstName: String = "",

  @get:JsonProperty("last_name")
  var lastName: String = ""
)
