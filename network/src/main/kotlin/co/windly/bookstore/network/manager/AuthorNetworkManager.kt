package co.windly.bookstore.network.manager

import co.windly.bookstore.network.dto.response.author.AuthorDto
import co.windly.bookstore.network.service.AuthorApi
import io.reactivex.Single
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.annotations.SchedulerSupport.IO
import io.reactivex.schedulers.Schedulers

@SchedulerSupport(value = IO)
class AuthorNetworkManager(private val api: AuthorApi) {

  //region Author

  fun getAuthorList(): Single<List<AuthorDto>> {
    return api
      .getAuthors()
      .map { it -> it.results }
      .subscribeOn(Schedulers.io())
  }

  //endregion
}
