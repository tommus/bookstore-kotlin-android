package co.windly.bookstore.network.dto.response.book

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
open class BookDto(

  @get:JsonProperty("id")
  var id: Long = 0L,

  @get:JsonProperty("title")
  var title: String = "",

  @get:JsonProperty("author")
  var author: Long = 0L,

  @get:JsonProperty("publisher")
  var publisher: Long = 0L,

  @get:JsonProperty("publication_year")
  var publicationYear: Int = 0,

  @get:JsonProperty("cover")
  var cover: String = ""
)
