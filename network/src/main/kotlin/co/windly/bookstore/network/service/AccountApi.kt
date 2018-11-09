package co.windly.bookstore.network.service

import co.windly.bookstore.network.dto.request.account.LoginBody
import co.windly.bookstore.network.dto.response.account.LoginDto
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountApi {

  @POST("account/login/")
  fun login(@Body body: LoginBody): Single<LoginDto>
}
