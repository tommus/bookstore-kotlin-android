package co.windly.bookstore.persistence.manager

import co.windly.bookstore.persistence.database.dao.BindingDao
import co.windly.bookstore.persistence.database.entity.binding.BindingEntity
import io.reactivex.Completable
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.annotations.SchedulerSupport.IO
import io.reactivex.schedulers.Schedulers

@SchedulerSupport(value = IO)
class BindingPersistenceManager(private val dao: BindingDao) {

  //region Binding

  fun saveBindingList(datas: List<BindingEntity>): Completable {
    return Completable.fromAction {

      // Insert bindings.
      dao.insert(datas)

      // Remove deprecated bindings.
      // TODO:
    }.subscribeOn(Schedulers.io())
  }

  //endregion
}
