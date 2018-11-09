package co.windly.bookstore.persistence.manager

import co.windly.bookstore.persistence.database.dao.BookDao
import co.windly.bookstore.persistence.database.entity.book.BookEntity
import io.reactivex.Completable
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.annotations.SchedulerSupport.IO
import io.reactivex.schedulers.Schedulers

@SchedulerSupport(value = IO)
class BookPersistenceManager(private val dao: BookDao) {

  //region Book

  fun saveBookList(datas: List<BookEntity>): Completable {
    return Completable.fromAction {

      // Insert books.
      dao.insert(datas)

      // Remove deprecated books.
      // TODO:

    }.subscribeOn(Schedulers.io())
  }

  fun saveBookDetails(data: BookEntity): Completable {
    return Completable.fromAction {

      // Insert book.
      dao.insert(data)

    }.subscribeOn(Schedulers.io())
  }

  //endregion
}
