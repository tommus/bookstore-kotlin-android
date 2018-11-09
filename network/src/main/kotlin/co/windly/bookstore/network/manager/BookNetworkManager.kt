package co.windly.bookstore.network.manager

import co.windly.bookstore.network.dto.response.book.BookDetailsDto
import co.windly.bookstore.network.dto.response.book.BookDto
import co.windly.bookstore.network.service.BookApi
import io.reactivex.Single
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.annotations.SchedulerSupport.IO
import io.reactivex.schedulers.Schedulers

@SchedulerSupport(value = IO)
class BookNetworkManager(private val api: BookApi) {

  //region Book

  fun getBookList(): Single<List<BookDto>> {
    return api
      .getBooks()
      .map { it -> it.results }
      .subscribeOn(Schedulers.io())
  }

  fun getBookDetails(id: Long): Single<BookDetailsDto> {
    return api
      .getBookDetails(id)
      .subscribeOn(Schedulers.io())
  }

  //endregion
}
