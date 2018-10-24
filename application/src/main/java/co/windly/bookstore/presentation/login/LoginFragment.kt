package co.windly.bookstore.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import co.windly.bookstore.R
import kotlinx.android.synthetic.main.fragment_login.signUpButton

class LoginFragment : Fragment() {

  //region Ui

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_login, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    signUpButton.setOnClickListener {
      val action = LoginFragmentDirections.actionLoginToRegister()
      it.findNavController().navigate(action)
    }
  }

  //endregion

}
