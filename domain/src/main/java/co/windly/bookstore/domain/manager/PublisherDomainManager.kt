package co.windly.bookstore.domain.manager

import co.windly.bookstore.domain.mapper.PublisherModelMapper
import co.windly.bookstore.network.manager.PublisherNetworkManager
import co.windly.bookstore.persistence.manager.PublisherPersistenceManager
import io.reactivex.Completable

class PublisherDomainManager(
  private val mapper: PublisherModelMapper,
  private val network: PublisherNetworkManager,
  private val persistence: PublisherPersistenceManager
) {

  //region Publisher

  fun downloadPublisherList(): Completable {
    return network
      .getPublisherList()
      .map { mapper.mapPublisherDtosToModels(it) }
      .map { mapper.mapPublisherModelsToEntities(it) }
      .flatMapCompletable { persistence.savePublisherList(it) }
  }

  //endregion
}
