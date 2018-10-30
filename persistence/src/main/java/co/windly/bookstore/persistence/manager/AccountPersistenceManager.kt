package co.windly.bookstore.persistence.manager

import io.reactivex.Completable
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.annotations.SchedulerSupport.IO
import io.reactivex.schedulers.Schedulers

@SchedulerSupport(value = IO)
class AccountPersistenceManager {

  //region Access Token

  fun saveAccessToken(accessToken: String): Completable {
    return Completable.fromAction {

      // Persist access token.
      // TODO:

    }.subscribeOn(Schedulers.io())
  }

  //endregion
}