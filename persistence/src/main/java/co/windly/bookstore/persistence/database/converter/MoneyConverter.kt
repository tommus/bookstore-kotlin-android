package co.windly.bookstore.persistence.database.converter

import androidx.room.TypeConverter
import org.joda.money.CurrencyUnit.of
import org.joda.money.Money

class MoneyConverter {

  @TypeConverter
  fun fromMoney(money: Money?): Long? {
    return money?.amountMinorLong
  }

  @TypeConverter
  fun fromLowestUnit(value: Long?): Money? {
    return value?.let { Money.ofMinor(of("PLN"), it) }
  }
}
