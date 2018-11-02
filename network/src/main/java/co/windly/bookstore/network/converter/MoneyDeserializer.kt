package co.windly.bookstore.network.converter

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import org.joda.money.CurrencyUnit.of
import org.joda.money.Money

class MoneyDeserializer : JsonDeserializer<Money?>() {

  //region Deserialization

  override fun deserialize(parser: JsonParser?, context: DeserializationContext?): Money? {
    return parser?.text?.trim()?.let { Money.of(of("PLN"), it.toDouble()) }
  }

  //endregion
}