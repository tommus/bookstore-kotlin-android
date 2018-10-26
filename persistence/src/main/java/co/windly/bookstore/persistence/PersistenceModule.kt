package co.windly.bookstore.persistence

import androidx.room.Room
import co.windly.bookstore.persistence.database.AndroidDatabase
import co.windly.bookstore.persistence.manager.AuthorPersistenceManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val persistenceModule = module {

  //region Managers

  single { AuthorPersistenceManager(get()) }

  //endregion

  //region Daos

  single { get<AndroidDatabase>().authorDao() }

  //endregion

  // region Database

  single {
    Room
      .databaseBuilder(androidContext(), AndroidDatabase::class.java, get("database-name"))
      .fallbackToDestructiveMigration()
      .build()
  }

  single("database-name") { "bookstore.db" }

  //endregion
}
