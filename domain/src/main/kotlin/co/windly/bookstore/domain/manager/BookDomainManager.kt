package co.windly.bookstore.domain.manager

import co.windly.bookstore.domain.mapper.BookModelMapper
import co.windly.bookstore.network.manager.BookNetworkManager
import co.windly.bookstore.persistence.manager.BookPersistenceManager
import io.reactivex.Completable

class BookDomainManager(
  private val mapper: BookModelMapper,
  private val network: BookNetworkManager,
  private val persistence: BookPersistenceManager
) {

  //region Book

  fun downloadBookList(): Completable {
    return network
      .getBookList()
      .map { mapper.mapBookDtosToModels(it) }
      .map { mapper.mapBookModelsToEntities(it) }
      .flatMapCompletable { persistence.saveBookList(it) }
  }

  fun downloadBookDetails(id: Long): Completable {
    return network
      .getBookDetails(id)
      .map { mapper.mapBookDetailsDtoToModel(it) }
      .map { mapper.mapBookDetailsModelToEntity(it) }
      .flatMapCompletable { persistence.saveBookDetails(it) }
  }

  //endregion
}
