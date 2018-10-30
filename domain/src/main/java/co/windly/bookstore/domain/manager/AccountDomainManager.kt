package co.windly.bookstore.domain.manager

import co.windly.bookstore.domain.mapper.AccountModelMapper
import co.windly.bookstore.network.manager.AccountNetworkManager
import co.windly.bookstore.persistence.manager.AccountPersistenceManager
import io.reactivex.Completable

class AccountDomainManager(
  private val mapper: AccountModelMapper,
  private val network: AccountNetworkManager,
  private val persistence: AccountPersistenceManager
) {

  //region Login

  fun loginAccount(username: String, password: String): Completable {
    return network
      .loginAccount(username, password)
      .map { mapper.mapLoginDtoToModel(it) }
      .flatMapCompletable { persistence.saveAccessToken(it) }
  }

  //endregion
}