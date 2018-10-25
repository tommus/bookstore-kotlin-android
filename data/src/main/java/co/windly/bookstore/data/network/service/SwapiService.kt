package co.windly.bookstore.data.network.service

import co.windly.bookstore.data.network.dto.response.SwapiRootResponse
import io.reactivex.Single
import retrofit2.http.GET

interface SwapiService {

    @GET("https://swapi.co/api/")
    fun getRoot(): Single<SwapiRootResponse>

}
