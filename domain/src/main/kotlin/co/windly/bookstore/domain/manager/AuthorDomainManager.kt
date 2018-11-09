package co.windly.bookstore.domain.manager

import co.windly.bookstore.domain.mapper.AuthorModelMapper
import co.windly.bookstore.network.manager.AuthorNetworkManager
import co.windly.bookstore.persistence.manager.AuthorPersistenceManager
import io.reactivex.Completable

class AuthorDomainManager(
  private val mapper: AuthorModelMapper,
  private val network: AuthorNetworkManager,
  private val persistence: AuthorPersistenceManager
) {

  //region Author

  fun downloadAuthorList(): Completable {
    return network
      .getAuthorList()
      .map { mapper.mapAuthorDtosToModels(it) }
      .map { mapper.mapAuthorModelsToEntities(it) }
      .flatMapCompletable { persistence.saveAuthorList(it) }
  }

  //endregion
}
