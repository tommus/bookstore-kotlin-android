package co.windly.bookstore.network.service

import co.windly.bookstore.network.dto.response.base.PageableDto
import co.windly.bookstore.network.dto.response.publisher.PublisherDto
import io.reactivex.Single
import retrofit2.http.GET

interface PublisherApi {

  @GET("bookstore/publishers")
  fun getPublishers(): Single<PageableDto<PublisherDto>>
}
