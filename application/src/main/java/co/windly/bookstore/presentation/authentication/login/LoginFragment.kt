package co.windly.bookstore.presentation.authentication.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import co.windly.bookstore.R
import co.windly.bookstore.domain.manager.AccountDomainManager
import co.windly.bookstore.presentation.main.MainActivity
import co.windly.bookstore.utility.log.ItLogger
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_login.forgotPasswordButton
import kotlinx.android.synthetic.main.fragment_login.loginField
import kotlinx.android.synthetic.main.fragment_login.passwordField
import kotlinx.android.synthetic.main.fragment_login.signInButton
import kotlinx.android.synthetic.main.fragment_login.signUpButton
import org.koin.android.ext.android.inject

class LoginFragment : Fragment() {

  //region Managers

  private val accountManager: AccountDomainManager by inject()

  private val disposables = CompositeDisposable()

  //endregion

  //region Ui

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_login, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    // Configure forgot password button.
    forgotPasswordButton.setOnClickListener {
      val action = LoginFragmentDirections.actionLoginToForgotPassword()
      it.findNavController().navigate(action)
    }

    // Configure sign in button.
    signInButton.setOnClickListener {

      // TODO: Move this piece of code to login account success method
      // Navigate to main activity.
      val intent = Intent(requireContext(), MainActivity::class.java)
      startActivity(intent)

      // Retrieve credentials.
      val username = loginField.text.toString()
      val password = passwordField.text.toString()

      // TODO: Validation.
      // TODO: Check subscribing. It doesn't work.
      /*disposables += accountManager
          .loginAccount(username = username, password = password)
          .subscribe(
              { this.handleLoginAccountSuccess() },
              { this.handleLoginAccountError(it) }
          )*/
    }

    // Configure sign up button.
    signUpButton.setOnClickListener {
      val action = LoginFragmentDirections.actionLoginToRegister()
      it.findNavController().navigate(action)
    }
  }

  override fun onDestroy() {
    disposables.clear()
    super.onDestroy()
  }

  //endregion

  //region Login Account

  private fun handleLoginAccountSuccess() {

    // Log the fact.
    ItLogger.v("Successfully signed in.")
  }

  private fun handleLoginAccountError(throwable: Throwable) {

    // Log an error.
    ItLogger.e("An error occurred while trying to sign in an account.")
    ItLogger.e(throwable.localizedMessage)
  }

  //endregion
}
