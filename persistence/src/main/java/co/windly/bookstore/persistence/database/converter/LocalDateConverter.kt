package co.windly.bookstore.persistence.database.converter

import androidx.room.TypeConverter
import org.joda.time.LocalDate

class LocalDateConverter {

  @TypeConverter
  fun fromLocalDate(date: LocalDate?): Long? {
    return date?.toDateTimeAtStartOfDay()?.millis
  }

  @TypeConverter
  fun toLocalDate(timestamp: Long?): LocalDate? {
    return timestamp?.let { LocalDate(it) }
  }
}