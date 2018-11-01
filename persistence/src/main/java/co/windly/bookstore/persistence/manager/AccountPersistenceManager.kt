package co.windly.bookstore.persistence.manager

import co.windly.bookstore.persistence.preferences.UserCachePrefs
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.annotations.SchedulerSupport.IO
import io.reactivex.schedulers.Schedulers

@SchedulerSupport(value = IO)
class AccountPersistenceManager(private val preferences: UserCachePrefs) {

  //region Access Token

  fun saveAccessToken(accessToken: String): Completable {
    return Completable.fromAction {

      // Persist access token.
      preferences
        .edit()
        .putAccessToken(accessToken)
        .apply()

    }.subscribeOn(Schedulers.io())
  }

  fun getAccessToken(): Single<String> {
    return Single.fromPublisher<String> {

      // Retrieve access token.
      val token = preferences.accessToken

      // Emit value.
      it.onNext(token)
      it.onComplete()
    }.subscribeOn(Schedulers.io())
  }

  fun clearAccessToken(): Completable {
    return Completable.fromAction {

      // Clear access token.
      preferences
        .edit()
        .removeAccessToken()
        .apply()
    }
  }

  //endregion
}
