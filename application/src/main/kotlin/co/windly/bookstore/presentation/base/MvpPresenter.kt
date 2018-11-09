package co.windly.bookstore.presentation.base

interface MvpPresenter<out V> {

  //region View

  val view: V

  //endregion
}
