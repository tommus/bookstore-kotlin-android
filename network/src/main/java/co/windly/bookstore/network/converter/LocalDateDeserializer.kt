package co.windly.bookstore.network.converter

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

class LocalDateDeserializer : JsonDeserializer<LocalDate?>() {

  //region Format

  companion object {
    val FORMAT: DateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd")
  }

  //endregion

  //region Deserialization

  override fun deserialize(parser: JsonParser?, context: DeserializationContext?): LocalDate? {
    return parser?.text?.trim()?.let { LocalDate.parse(it, FORMAT) }
  }

  //endregion
}
