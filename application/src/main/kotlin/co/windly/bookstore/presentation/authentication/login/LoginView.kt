package co.windly.bookstore.presentation.authentication.login

import co.windly.bookstore.presentation.base.fragment.MvpFragmentView

interface LoginView : MvpFragmentView<LoginPresenter> {

  //region Navigation

  fun navigateToForgotPasswordView()

  fun navigateToMainView()

  fun navigateToRegisterView()

  //endregion

  //region Credentials

  fun retrieveUsername(): String

  fun retrievePassword(): String

  //endregion

  //region Errors

  fun showIncorrectCredentialsError()

  //endregion
}
