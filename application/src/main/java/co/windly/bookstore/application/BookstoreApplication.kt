package co.windly.bookstore.application

import android.app.Application
import co.windly.bookstore.domain.DomainModule
import co.windly.bookstore.utility.BuildConfig
import co.windly.bookstore.utility.debug.DebugBridge
import org.koin.android.ext.android.startKoin

class BookstoreApplication : Application() {

  //region Lifecycle

  override fun onCreate() {
    super.onCreate()

    // Initialize dependency graph.
    initializeDependencyInjection()

    // Initialize tools.
    initializeDebugBridge()
  }

  //endregion

  //region Debug Bridge

  private fun initializeDebugBridge() {
    DebugBridge
      .init(BuildConfig.ENABLE_DEBUG_BRIDGE, this)
  }

  //endregion

  //region Dependency Injection

  private fun initializeDependencyInjection() {
    startKoin(this, listOf(DomainModule().domainModule))
  }

  //endregion
}
