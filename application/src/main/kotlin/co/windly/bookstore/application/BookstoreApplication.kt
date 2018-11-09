package co.windly.bookstore.application

import android.app.Application
import co.windly.bookstore.domain.DomainModule
import co.windly.bookstore.presentation.authentication.authenticationModule
import co.windly.bookstore.utility.BuildConfig
import co.windly.bookstore.utility.debug.DebugBridge
import co.windly.bookstore.utility.log.ItLogger
import com.squareup.leakcanary.LeakCanary
import org.koin.android.ext.android.startKoin

class BookstoreApplication : Application() {

  //region Lifecycle

  override fun onCreate() {
    super.onCreate()

    // Initialize dependency graph.
    initializeDependencyInjection()

    // Initialize tools.
    initializeDebugBridge()
    initializeLeakCanary()
    initializeLogger()
  }

  //endregion

  //region Debug Bridge

  private fun initializeDebugBridge() {
    DebugBridge
      .init(BuildConfig.ENABLE_DEBUG_BRIDGE, this)
  }

  //endregion

  //region Dependency Injection

  private val bookstoreApp = listOf(
    DomainModule().domainModule,
    authenticationModule
  )

  private fun initializeDependencyInjection() {
    startKoin(this, bookstoreApp)
  }

  //endregion

  //region Leak Canary

  private fun initializeLeakCanary() {

    if (LeakCanary.isInAnalyzerProcess(this) && !BuildConfig.ENABLE_LEAK_CANARY) {
      // This process is dedicated to Leak Canary for heap analysis.
      // Do not initialize application in this process.
      ItLogger.v("Leak Canary will not be initialized in during the analyzer process.")
    }

    LeakCanary
      .install(this)
  }

  //endregion

  //region Logger

  private fun initializeLogger() {
    ItLogger
      .init(BuildConfig.ENABLE_LOGGER)
  }

  //endregion
}
