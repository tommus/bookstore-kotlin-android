package co.windly.bookstore.network.service

import co.windly.bookstore.network.dto.response.base.PageableDto
import co.windly.bookstore.network.dto.response.book.BookDetailsDto
import co.windly.bookstore.network.dto.response.book.BookDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BookApi {

  @GET("bookstore/books/")
  fun getBooks(): Single<PageableDto<BookDto>>

  @GET("bookstore/books/{id}/")
  fun getBookDetails(@Path("id") id: Long): Single<BookDetailsDto>
}
