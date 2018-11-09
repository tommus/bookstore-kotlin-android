package co.windly.bookstore.domain.model

import org.joda.money.CurrencyUnit.of
import org.joda.money.Money
import org.joda.time.LocalDate

class BookDetails(

  var binding: Long = 0L,

  var pages: Int = 0,

  var format: String = "",

  var isbn: String = "",

  var ean: String = "",

  var releaseDate: LocalDate = LocalDate.now(),

  var available: Boolean = false,

  var priceBase: Money = Money.zero(of("PLN")),

  var priceDiscounted: Money = Money.zero(of("PLN")),

  var description: String = ""

) : Book()
