package co.windly.bookstore.network.service

import co.windly.bookstore.network.dto.response.binding.BindingDto
import io.reactivex.Single
import retrofit2.http.GET

interface BindingApi {

  @GET("bookstore/bindings")
  fun getBindings(): Single<List<BindingDto>>
}
