package co.windly.bookstore.persistence.manager

import co.windly.bookstore.persistence.database.dao.PublisherDao
import co.windly.bookstore.persistence.database.entity.publisher.PublisherEntity
import io.reactivex.Completable
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.annotations.SchedulerSupport.IO
import io.reactivex.schedulers.Schedulers

@SchedulerSupport(value = IO)
class PublisherPersistenceManager(private val dao: PublisherDao) {

  //region Publisher

  fun savePublisherList(datas: List<PublisherEntity>): Completable {
    return Completable.fromAction {

      // Insert publishers.
      dao.insert(datas)

      // Remove deprecated publishers.
      // TODO:

    }.subscribeOn(Schedulers.io())
  }

  //endregion
}
