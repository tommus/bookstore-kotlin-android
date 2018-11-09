package co.windly.bookstore.utility.debug

import android.content.Context
import com.facebook.stetho.Stetho

class DebugBridge {

  //region Initialization

  companion object {
    fun init(enable: Boolean, context: Context) {
      if (enable) {
        Stetho.initializeWithDefaults(context)
      }
    }
  }

  //endregion
}