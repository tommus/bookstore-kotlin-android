package co.windly.bookstore.presentation.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class MvpActivity<P : MvpActivityPresenter<MvpActivityView<P>, P>> : AppCompatActivity(), MvpActivityView<P> {

  //region Ui

  @LayoutRes
  abstract fun getLayout(): Int

  //endregion

  //region Lifecycle

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(getLayout())
    initializeViews()
  }

  override fun onDestroy() {
    presenter.clearDisposables()
    super.onDestroy()
  }

  //endregion

  //region View Configuration

  open fun initializeViews() {
    // No-op.
  }

  //endregion
}