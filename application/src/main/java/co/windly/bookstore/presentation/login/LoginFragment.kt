package co.windly.bookstore.presentation.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import co.windly.bookstore.R
import co.windly.bookstore.domain.manager.AuthorDomainManager
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import kotlinx.android.synthetic.main.fragment_login.signUpButton
import org.koin.android.ext.android.inject

class LoginFragment : Fragment() {

  //region Managers

  private val authorManager: AuthorDomainManager by inject()

  private val disposables = CompositeDisposable()

  //endregion

  //region Ui

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_login, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    signUpButton.setOnClickListener {
      val action = LoginFragmentDirections.actionLoginToRegister()
      it.findNavController().navigate(action)
    }

    disposables += authorManager
      .downloadAuthorList()
      .subscribe(
        { this.handleDownloadAuthorListSuccess() },
        { this.handleDownloadAuthorListError(it) }
      )
  }

  override fun onDestroy() {
    disposables.clear()
    super.onDestroy()
  }

  //endregion

  //region Download Authors

  private fun handleDownloadAuthorListSuccess() {
    // TODO:
    Log.d("Foo", "Success")
  }

  private fun handleDownloadAuthorListError(throwable: Throwable) {
    // TODO:
    Log.e("Foo", throwable.localizedMessage)
  }

  //endregion
}
