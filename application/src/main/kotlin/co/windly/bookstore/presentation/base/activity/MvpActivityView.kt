package co.windly.bookstore.presentation.base.activity

import co.windly.bookstore.presentation.base.MvpView

interface MvpActivityView<out P : MvpActivityPresenter<*, P>> : MvpView<P> {
  // No-op.
}
