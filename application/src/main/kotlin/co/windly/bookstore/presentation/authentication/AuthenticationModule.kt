package co.windly.bookstore.presentation.authentication

import co.windly.bookstore.presentation.authentication.Params.LOGIN_VIEW
import co.windly.bookstore.presentation.authentication.login.LoginPresenter
import org.koin.dsl.module.module

val authenticationModule = module {

  factory { params -> LoginPresenter(get(), params[LOGIN_VIEW]) as LoginPresenter }
}

object Params {
  const val LOGIN_VIEW = 0
}
