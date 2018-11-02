package co.windly.bookstore.network.manager

import co.windly.bookstore.network.dto.response.binding.BindingDto
import co.windly.bookstore.network.service.BindingApi
import io.reactivex.Single
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.annotations.SchedulerSupport.IO
import io.reactivex.schedulers.Schedulers

@SchedulerSupport(value = IO)
class BindingNetworkManager(private val api: BindingApi) {

  //region Binding

  fun getBindingList(): Single<List<BindingDto>> {
    return api
      .getBindings()
      .subscribeOn(Schedulers.io())
  }

  //endregion
}
