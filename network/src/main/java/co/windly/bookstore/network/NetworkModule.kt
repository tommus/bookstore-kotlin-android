package co.windly.bookstore.network


import co.windly.bookstore.network.manager.AuthorNetworkManager
import co.windly.bookstore.network.service.AuthorApi
import co.windly.bookstore.utility.BuildConfig.SERVER_CONNECTION_TIMEOUT
import co.windly.bookstore.utility.BuildConfig.SERVER_LOGGING_LEVEL
import co.windly.bookstore.utility.BuildConfig.SERVER_READ_TIMEOUT
import co.windly.bookstore.utility.BuildConfig.SERVER_URL
import co.windly.bookstore.utility.BuildConfig.SERVER_WRITE_TIMEOUT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit.SECONDS

val networkModule = module {

  //region Managers

  single { AuthorNetworkManager(get()) }

  //endregion

  //region Api

  single { get<Retrofit>().create(AuthorApi::class.java) }

  //endregion

  //region Retrofit

  single {
    get<Retrofit.Builder>()
      .baseUrl(get<String>("server-uri"))
      .build()
  }

  single("server-uri") { SERVER_URL }

  //endregion

  //region Retrofit - Builder

  single {
    Retrofit.Builder()
      .addConverterFactory(get())
      .addCallAdapterFactory(get())
      .client(get())
  }

  //endregion

  //region Retrofit - Factories

  single<Converter.Factory> { JacksonConverterFactory.create() }

  single<CallAdapter.Factory> { RxJava2CallAdapterFactory.create() }

  //endregion

  //region Retrofit - Http

  single<OkHttpClient> { get<OkHttpClient.Builder>().build() }

  single<OkHttpClient.Builder> {
    OkHttpClient.Builder()
      .connectTimeout(SERVER_CONNECTION_TIMEOUT, SECONDS)
      .readTimeout(SERVER_READ_TIMEOUT, SECONDS)
      .writeTimeout(SERVER_WRITE_TIMEOUT, SECONDS)
      .addInterceptor(HttpLoggingInterceptor().setLevel(get()))
  }

  single {
    HttpLoggingInterceptor
      .Level
      .valueOf(SERVER_LOGGING_LEVEL.trim().toUpperCase())
  }

  //endregion
}
