package co.windly.bookstore.presentation.authentication.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import co.windly.bookstore.R
import co.windly.bookstore.presentation.base.fragment.MvpFragment
import co.windly.bookstore.presentation.main.MainActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.forgotPasswordButton
import kotlinx.android.synthetic.main.fragment_login.loginContainer
import kotlinx.android.synthetic.main.fragment_login.loginField
import kotlinx.android.synthetic.main.fragment_login.passwordField
import kotlinx.android.synthetic.main.fragment_login.signInButton
import kotlinx.android.synthetic.main.fragment_login.signUpButton
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LoginFragment : MvpFragment<LoginPresenter>(), LoginView {

  //region Ui

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_login, container, false)
  }

  //endregion

  //region Presenter

  override val presenter: LoginPresenter by inject { parametersOf(this) }

  //endregion

  //region Navigation

  override fun navigateToForgotPasswordView() {

    // Prepare action and navigate.
    val action = LoginFragmentDirections.actionLoginToForgotPassword()
    findNavController().navigate(action)
  }

  override fun navigateToMainView() {

    // Prepare intent and navigate.
    val intent = Intent(requireContext(), MainActivity::class.java)
    startActivity(intent)
  }

  override fun navigateToRegisterView() {

    // Prepare action and navigate.
    val action = LoginFragmentDirections.actionLoginToRegister()
    findNavController().navigate(action)
  }

  //endregion

  //region Lifecycle

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    // Configure forgot password button.
    forgotPasswordButton.setOnClickListener { presenter.onForgotPasswordButtonClicked() }

    // Configure sign in button.
    signInButton.setOnClickListener { presenter.onSignInButtonClicked() }

    // Configure sign up button.
    signUpButton.setOnClickListener { presenter.onSignUpButtonClicked() }
  }

  //endregion

  //region Credentials

  override fun retrieveUsername(): String = loginField.text.toString()

  override fun retrievePassword(): String = passwordField.text.toString()

  //endregion

  //region Errors

  override fun showIncorrectCredentialsError() {

    // Show an error.
    Snackbar
      .make(loginContainer, R.string.login_error_invalid_credentials, Snackbar.LENGTH_SHORT)
      .show()
  }

  //endregion
}
