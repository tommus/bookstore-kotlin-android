package co.windly.bookstore.data.network

import co.windly.bookstore.data.network.service.SwapiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

//region Module declaration

val networkModule = module {

  //region OkHttpClient

  single<OkHttpClient> {
    OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()
  }

  //endregion

  //region CallAdapter Factory

  factory<CallAdapter.Factory> { RxJava2CallAdapterFactory.create() }

  //endregion

  //region Converter Factory

  factory<Converter.Factory> { JacksonConverterFactory.create() }

  //endregion

  //region Retrofit

  single<Retrofit> {
    Retrofit.Builder()
        .addCallAdapterFactory(get())
        .addConverterFactory(get())
        .baseUrl("https://swapi.co/")
        .client(get())
        .build()
  }

  //endregion

  //region Service

  single { provideSwapiService(get()) }

  //endregion
}

//endregion

//region Services

private fun provideSwapiService(retrofit: Retrofit): SwapiService {
  return retrofit.create(SwapiService::class.java)
}

//endregion

