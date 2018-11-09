package co.windly.bookstore.network.dto.response.book

import co.windly.bookstore.network.converter.LocalDateDeserializer
import co.windly.bookstore.network.converter.MoneyDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import org.joda.money.CurrencyUnit.of
import org.joda.money.Money
import org.joda.time.LocalDate

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class BookDetailsDto(

  @get:JsonProperty("binding")
  var binding: Long = 0L,

  @get:JsonProperty("pages")
  var pages: Int = 0,

  @get:JsonProperty("format")
  var format: String = "",

  @get:JsonProperty("isbn")
  var isbn: String = "",

  @get:JsonProperty("ean")
  var ean: String = "",

  @get:JsonProperty("release_date")
  @get:JsonDeserialize(using = LocalDateDeserializer::class)
  var releaseDate: LocalDate = LocalDate.now(),

  @get:JsonProperty("available")
  var available: Boolean = false,

  @get:JsonProperty("price_base")
  @get:JsonDeserialize(using = MoneyDeserializer::class)
  var priceBase: Money = Money.zero(of("PLN")),

  @get:JsonProperty("price_discounted")
  @get:JsonDeserialize(using = MoneyDeserializer::class)
  var priceDiscounted: Money = Money.zero(of("PLN")),

  @get:JsonProperty("description")
  var description: String = ""

) : BookDto()
