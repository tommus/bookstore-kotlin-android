package co.windly.bookstore.utility.log

import timber.log.Timber
import timber.log.Timber.DebugTree

class ItLogger {

  companion object {

    //region Initialization

    fun init(enable: Boolean) {
      if (enable) {
        Timber.plant(DebugTree())
      }
    }

    //endregion

    //region Verbose

    fun v(message: String, vararg objects: Any) {
      Timber.v(message, objects)
    }

    fun v(throwable: Throwable, message: String, vararg objects: Any) {
      Timber.v(throwable, message, objects)
    }

    //endregion

    //region Debug

    fun d(message: String, vararg objects: Any) {
      Timber.d(message, objects)
    }

    fun d(throwable: Throwable, message: String, vararg objects: Any) {
      Timber.d(throwable, message, objects)
    }

    //endregion

    //region Info

    fun i(message: String, vararg objects: Any) {
      Timber.i(message, objects)
    }

    fun i(throwable: Throwable, message: String, vararg objects: Any) {
      Timber.i(throwable, message, objects)
    }

    //endregion

    //region Warning

    fun w(message: String, vararg objects: Any) {
      Timber.w(message, objects)
    }

    fun w(throwable: Throwable, message: String, vararg objects: Any) {
      Timber.w(throwable, message, objects)
    }

    //endregion

    //region Error

    fun e(message: String, vararg objects: Any) {
      Timber.e(message, objects)
    }

    fun e(throwable: Throwable, message: String, vararg objects: Any) {
      Timber.e(throwable, message, objects)
    }

    //endregion

    //region What a Terrible Failure

    fun wtf(message: String, vararg objects: Any) {
      Timber.wtf(message, objects)
    }

    fun wtf(throwable: Throwable, message: String, vararg objects: Any) {
      Timber.wtf(throwable, message, objects)
    }

    //endregion

  }
}


