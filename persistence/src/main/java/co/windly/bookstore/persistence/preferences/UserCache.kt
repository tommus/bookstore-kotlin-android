package co.windly.bookstore.persistence.preferences

import android.content.Context.MODE_PRIVATE
import co.windly.androidxprefs.annotation.DefaultString
import co.windly.androidxprefs.annotation.Prefs

@Prefs(value = "UserCachePreferences", fileMode = MODE_PRIVATE)
class UserCache(

  //region Access Token

  @DefaultString("")
  var accessToken: String

  //endregion
)
