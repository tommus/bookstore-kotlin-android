package co.windly.bookstore.persistence

import androidx.room.Room
import co.windly.bookstore.persistence.database.AndroidDatabase
import co.windly.bookstore.persistence.manager.AccountPersistenceManager
import co.windly.bookstore.persistence.manager.AuthorPersistenceManager
import co.windly.bookstore.persistence.manager.BindingPersistenceManager
import co.windly.bookstore.persistence.preferences.UserCachePrefs
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val persistenceModule = module {

  //region Managers

  single { AccountPersistenceManager(get()) }

  single { AuthorPersistenceManager(get()) }

  single { BindingPersistenceManager(get()) }

  //endregion

  //region Shared Preferences

  single { UserCachePrefs.get(androidContext()) }

  //endregion

  //region Data Access Objects

  single { get<AndroidDatabase>().authorDao() }

  single { get<AndroidDatabase>().bindingDao() }

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
