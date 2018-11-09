package co.windly.bookstore.persistence.database.entity.book

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.joda.money.Money
import org.joda.time.LocalDate

@Entity(tableName = "books")
data class BookEntity(

  @PrimaryKey
  @ColumnInfo(name = "id")
  var id: Long = 0L,

  @ColumnInfo(name = "title")
  var title: String = "",

  @ColumnInfo(name = "author")
  var author: Long = 0L,

  @ColumnInfo(name = "publisher")
  var publisher: Long = 0L,

  @ColumnInfo(name = "publication_year")
  var publicationYear: Int = 0,

  @ColumnInfo(name = "binding")
  var binding: Long? = null,

  @ColumnInfo(name = "pages")
  var pages: Int? = null,

  @ColumnInfo(name = "format")
  var format: String? = null,

  @ColumnInfo(name = "isbn")
  var isbn: String? = null,

  @ColumnInfo(name = "ean")
  var ean: String? = null,

  @ColumnInfo(name = "release_date")
  var releaseDate: LocalDate? = null,

  @ColumnInfo(name = "available")
  var available: Boolean? = null,

  @ColumnInfo(name = "price_base")
  var priceBase: Money? = null,

  @ColumnInfo(name = "price_discounted")
  var priceDiscounted: Money? = null,

  @ColumnInfo(name = "description")
  var description: String? = null,

  @ColumnInfo(name = "cover")
  var cover: String = ""
)
