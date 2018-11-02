package co.windly.bookstore.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import co.windly.bookstore.persistence.database.dao.AuthorDao
import co.windly.bookstore.persistence.database.dao.BindingDao
import co.windly.bookstore.persistence.database.entity.author.AuthorEntity
import co.windly.bookstore.persistence.database.entity.binding.BindingEntity

@Database(
  version = 2,
  exportSchema = false,
  entities = [
    AuthorEntity::class,
    BindingEntity::class
  ]
)
abstract class AndroidDatabase : RoomDatabase() {

  //region Dao

  abstract fun authorDao(): AuthorDao

  abstract fun bindingDao(): BindingDao

  //endregion

  //region Migrations

  // TODO:

  //endregion
}
