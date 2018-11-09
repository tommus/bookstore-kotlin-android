package co.windly.bookstore.presentation.base.fragment

import co.windly.bookstore.presentation.base.MvpView

interface MvpFragmentView<out P : MvpFragmentPresenter<*, P>> : MvpView<P> {
  // No-op.
}
