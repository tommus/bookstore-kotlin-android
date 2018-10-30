package co.windly.bookstore.presentation.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import co.windly.bookstore.R
import co.windly.bookstore.domain.manager.AccountDomainManager
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
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

    // Configure sign in button.
    signInButton.setOnClickListener {

      // Retrieve credentials.
      val username = loginField.text.toString()
      val password = passwordField.text.toString()

      // TODO: Validation.

      disposables += accountManager
        .loginAccount(username = username, password = password)
        .subscribe(
          { this.handleLoginAccountSuccess() },
          { this.handleLoginAccountError(it) }
        )
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
    Log.v(this::class.simpleName, "Successfully signed in.")
    // TODO:
  }

  private fun handleLoginAccountError(throwable: Throwable) {

    // Log an error.
    Log.e(this::class.simpleName, "An error occurred while trying to sign in an account.")
    Log.e(this::class.simpleName, throwable.localizedMessage)
    // TODO:
  }

  //endregion
}
