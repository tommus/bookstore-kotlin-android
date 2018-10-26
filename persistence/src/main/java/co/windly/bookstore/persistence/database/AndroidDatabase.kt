package co.windly.bookstore.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import co.windly.bookstore.persistence.database.dao.AuthorDao
import co.windly.bookstore.persistence.database.entity.author.AuthorEntity

@Database(
  version = 1,
  exportSchema = false,
  entities = [
    AuthorEntity::class
  ]
)
abstract class AndroidDatabase : RoomDatabase() {

  //region Dao

  abstract fun authorDao(): AuthorDao

  //endregion

  //region Migrations

  // TODO:

  //endregion
}
