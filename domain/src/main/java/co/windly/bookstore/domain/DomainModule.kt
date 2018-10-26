package co.windly.bookstore.domain

import co.windly.bookstore.domain.manager.AuthorDomainManager
import co.windly.bookstore.domain.mapper.AuthorModelMapper
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

    single {
      AuthorDomainManager(get(), get(), get())
    }

    //endregion

    //region Mappers

    single { AuthorModelMapper(get()) }

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