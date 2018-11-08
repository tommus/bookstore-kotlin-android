package co.windly.bookstore.presentation.main

import androidx.annotation.LongDef


class MainMenuItem {

  //region Definition

  @LongDef(PROFILE,
    HOME,
    BOOKS,
    BASKET,
    SETTINGS,
    ABOUT)
  @Retention(AnnotationRetention.SOURCE)
  annotation class Definition

  //endregion

  //region Constants

  companion object {

    // User profile view.
    const val PROFILE = 0L

    // Home view.
    const val HOME = 1L

    // Book list view.
    const val BOOKS = 2L

    // Cart view.
    const val BASKET = 3L

    // Settings view.
    const val SETTINGS = 4L

    // About view.
    const val ABOUT = 5L
  }

  //endregion
}