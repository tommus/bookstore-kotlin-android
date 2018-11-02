package co.windly.bookstore.domain

import co.windly.bookstore.domain.manager.AccountDomainManager
import co.windly.bookstore.domain.manager.AuthorDomainManager
import co.windly.bookstore.domain.manager.BindingDomainManager
import co.windly.bookstore.domain.manager.BookDomainManager
import co.windly.bookstore.domain.manager.PublisherDomainManager
import co.windly.bookstore.domain.mapper.AccountModelMapper
import co.windly.bookstore.domain.mapper.AuthorModelMapper
import co.windly.bookstore.domain.mapper.BindingModelMapper
import co.windly.bookstore.domain.mapper.BookModelMapper
import co.windly.bookstore.domain.mapper.PublisherModelMapper
import co.windly.bookstore.network.networkModule
import co.windly.bookstore.persistence.persistenceModule
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.loadKoinModules
import org.modelmapper.ModelMapper

class DomainModule : KoinComponent {

  init {
    loadKoinModules(networkModule, persistenceModule)
  }

  val domainModule = module {

    //region Managers

    single { AccountDomainManager(get(), get(), get()) }

    single { AuthorDomainManager(get(), get(), get()) }

    single { BookDomainManager(get(), get(), get()) }

    single { BindingDomainManager(get(), get(), get()) }

    single { PublisherDomainManager(get(), get(), get()) }

    //endregion

    //region Mappers

    single { AccountModelMapper(get()) }

    single { AuthorModelMapper(get()) }

    single { BookModelMapper(get()) }

    single { BindingModelMapper(get()) }

    single { PublisherModelMapper(get()) }

    //endregion

    //region Model Mapper

    single {
      ModelMapper().apply {
        with(configuration) {
          isAmbiguityIgnored = true
          isSkipNullEnabled = true
        }
      }
    }

    //endregion
  }
}
