package co.windly.bookstore.domain.manager

import co.windly.bookstore.domain.mapper.BindingModelMapper
import co.windly.bookstore.network.manager.BindingNetworkManager
import co.windly.bookstore.persistence.manager.BindingPersistenceManager
import io.reactivex.Completable

class BindingDomainManager(
  private val mapper: BindingModelMapper,
  private val network: BindingNetworkManager,
  private val persistence: BindingPersistenceManager
) {

  //region Binding

  fun downloadBindingList(): Completable {
    return network
      .getBindingList()
      .map { mapper.mapBindingDtosToModels(it) }
      .map { mapper.mapBindingModelsToEntities(it) }
      .flatMapCompletable { persistence.saveBindingList(it) }
  }

  //endregion
}
