package co.windly.bookstore.network.manager

import co.windly.bookstore.network.dto.response.publisher.PublisherDto
import co.windly.bookstore.network.service.PublisherApi
import io.reactivex.Single
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.annotations.SchedulerSupport.IO
import io.reactivex.schedulers.Schedulers

@SchedulerSupport(value = IO)
class PublisherNetworkManager(private val api: PublisherApi) {

  //region Publisher

  fun getPublisherList(): Single<List<PublisherDto>> {
    return api
      .getPublishers()
      .map { it -> it.results }
      .subscribeOn(Schedulers.io())
  }

  //endregion
}
