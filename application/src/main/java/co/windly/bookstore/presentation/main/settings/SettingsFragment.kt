package co.windly.bookstore.presentation.main.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.windly.bookstore.R

class SettingsFragment : Fragment() {

  //region Ui

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_settings, container, false)
  }

  //endregion
}