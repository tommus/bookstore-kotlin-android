package co.windly.bookstore.network.dto.request.account

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class LoginBody(

  @get:JsonProperty("username")
  var username: String = "",

  @get:JsonProperty("password")
  var password: String = ""
)
