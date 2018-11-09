package co.windly.bookstore.presentation.base.fragment

import androidx.fragment.app.Fragment
import co.windly.bookstore.presentation.base.MvpView

abstract class MvpFragment<out P : MvpFragmentPresenter<*, P>> : Fragment(), MvpView<P> {

  // TODO:

  //region Lifecycle

  override fun onDestroy() {
    presenter.clearDisposables()
    super.onDestroy()
  }

  //endregion
}
