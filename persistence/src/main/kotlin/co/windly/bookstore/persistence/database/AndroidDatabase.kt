package co.windly.bookstore.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import co.windly.bookstore.persistence.database.converter.LocalDateConverter
import co.windly.bookstore.persistence.database.converter.MoneyConverter
import co.windly.bookstore.persistence.database.dao.AuthorDao
import co.windly.bookstore.persistence.database.dao.BindingDao
import co.windly.bookstore.persistence.database.dao.BookDao
import co.windly.bookstore.persistence.database.dao.PublisherDao
import co.windly.bookstore.persistence.database.entity.author.AuthorEntity
import co.windly.bookstore.persistence.database.entity.binding.BindingEntity
import co.windly.bookstore.persistence.database.entity.book.BookEntity
import co.windly.bookstore.persistence.database.entity.publisher.PublisherEntity

@Database(
  version = 4,
  exportSchema = false,
  entities = [
    AuthorEntity::class,
    BookEntity::class,
    BindingEntity::class,
    PublisherEntity::class
  ]
)
@TypeConverters(
  value = [
    LocalDateConverter::class,
    MoneyConverter::class
  ]
)
abstract class AndroidDatabase : RoomDatabase() {

  //region Dao

  abstract fun authorDao(): AuthorDao

  abstract fun bookDao(): BookDao

  abstract fun bindingDao(): BindingDao

  abstract fun publisherDao(): PublisherDao

  //endregion

  //region Migrations

  // TODO:

  //endregion
}
