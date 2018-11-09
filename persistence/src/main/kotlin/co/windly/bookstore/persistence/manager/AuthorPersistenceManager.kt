package co.windly.bookstore.persistence.manager

import co.windly.bookstore.persistence.database.dao.AuthorDao
import co.windly.bookstore.persistence.database.entity.author.AuthorEntity
import io.reactivex.Completable
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.annotations.SchedulerSupport.IO
import io.reactivex.schedulers.Schedulers

@SchedulerSupport(value = IO)
class AuthorPersistenceManager(private val dao: AuthorDao) {

  //region Author

  fun saveAuthorList(datas: List<AuthorEntity>): Completable {
    return Completable.fromAction {

      // Insert authors.
      dao.insert(datas)

      // Remove deprecated authors.
      // TODO:

    }.subscribeOn(Schedulers.io())
  }

  //endregion
}
