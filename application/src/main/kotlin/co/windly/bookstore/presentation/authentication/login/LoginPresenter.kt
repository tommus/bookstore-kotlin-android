package co.windly.bookstore.presentation.authentication.login

import co.windly.bookstore.domain.manager.AccountDomainManager
import co.windly.bookstore.presentation.base.fragment.MvpFragmentPresenter
import co.windly.bookstore.utility.log.ItLogger
import io.reactivex.rxkotlin.addTo

class LoginPresenter(
  private val accountManager: AccountDomainManager,
  override var view: LoginView
) : MvpFragmentPresenter<LoginView, LoginPresenter>() {

  //region Forgot Password

  fun onForgotPasswordButtonClicked() {

    // Navigate to forgot password view.
    view.navigateToForgotPasswordView()
  }

  //endregion

  //region Sign In

  fun onSignInButtonClicked() {

    // Perform login.
    loginAccount()
  }

  //endregion

  //region Sign Up

  fun onSignUpButtonClicked() {

    // Navigate to register view.
    view.navigateToRegisterView()
  }

  //endregion

  //region Login Account

  private fun loginAccount() {

    // Retrieve user credentials.
    val username = view.retrieveUsername()
    val password = view.retrievePassword()

    // TODO: Validation.

    accountManager
      .loginAccount(username, password)
      .subscribe(
        { this.handleLoginAccountSuccess() },
        { this.handleLoginAccountError(it) }
      )
      .addTo(disposables)
  }

  private fun handleLoginAccountSuccess() {

    // Log the fact.
    ItLogger.v("Successfully signed in.")

    // Navigate to main view.
    view.navigateToMainView()
  }

  private fun handleLoginAccountError(throwable: Throwable) {

    // Log an error.
    ItLogger.e("An error occurred while trying to sign in an account.")
    ItLogger.e(throwable.localizedMessage)

    // Show an error.
    view.showIncorrectCredentialsError()
  }

  //endregion
}
