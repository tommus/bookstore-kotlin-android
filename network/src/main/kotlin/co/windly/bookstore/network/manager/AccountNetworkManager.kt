package co.windly.bookstore.network.manager

import co.windly.bookstore.network.dto.request.account.LoginBody
import co.windly.bookstore.network.dto.response.account.LoginDto
import co.windly.bookstore.network.service.AccountApi
import io.reactivex.Single
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.annotations.SchedulerSupport.IO
import io.reactivex.schedulers.Schedulers

@SchedulerSupport(value = IO)
class AccountNetworkManager(private val api: AccountApi) {

  //region Login

  fun loginAccount(username: String, password: String): Single<LoginDto> {
    return api
      .login(LoginBody().apply {
        this.username = username
        this.password = password
      }).subscribeOn(Schedulers.io())
  }

  //endregion
}