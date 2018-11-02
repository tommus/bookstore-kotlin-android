package co.windly.bookstore.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import co.windly.bookstore.persistence.database.dao.AuthorDao
import co.windly.bookstore.persistence.database.dao.BindingDao
import co.windly.bookstore.persistence.database.dao.PublisherDao
import co.windly.bookstore.persistence.database.entity.author.AuthorEntity
import co.windly.bookstore.persistence.database.entity.binding.BindingEntity
import co.windly.bookstore.persistence.database.entity.publisher.PublisherEntity

@Database(
  version = 3,
  exportSchema = false,
  entities = [
    AuthorEntity::class,
    BindingEntity::class,
    PublisherEntity::class
  ]
)
abstract class AndroidDatabase : RoomDatabase() {

  //region Dao

  abstract fun authorDao(): AuthorDao

  abstract fun bindingDao(): BindingDao

  abstract fun publisherDao(): PublisherDao

  //endregion

  //region Migrations

  // TODO:

  //endregion
}
