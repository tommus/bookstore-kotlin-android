package co.windly.bookstore.presentation.base

interface MvpView<out P : MvpPresenter<*>> {

  //region Presenter

  val presenter: P

  //endregion
}
