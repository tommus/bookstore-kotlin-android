package co.windly.bookstore.network.service

import co.windly.bookstore.network.dto.response.author.AuthorDto
import co.windly.bookstore.network.dto.response.base.PageableDto
import io.reactivex.Single
import retrofit2.http.GET

interface AuthorApi {

  @GET("bookstore/authors/")
  fun getAuthors(): Single<PageableDto<AuthorDto>>
}