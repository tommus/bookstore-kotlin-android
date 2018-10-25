package co.windly.bookstore.application

import android.app.Application
import co.windly.bookstore.data.network.networkModule
import org.koin.android.ext.android.startKoin

class BookstoreApplication : Application() {

  //region Lifecycle

  override fun onCreate() {
    super.onCreate()

    initializeKoin()
  }

  //endregion

  //region Koin

  private fun initializeKoin() {
    startKoin(this, listOf(networkModule))
  }

  //endregion

}