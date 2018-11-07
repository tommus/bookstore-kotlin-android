package co.windly.bookstore.presentation.main.definition

import androidx.annotation.IntDef

class DrawerItemIdentifier {

  @IntDef(PROFILE, HOME, BOOKS, BASKET, SETTINGS, ABOUT)
  @Retention(AnnotationRetention.SOURCE)
  annotation class DrawerItemIdentifierType

  companion object {
    const val PROFILE = 0
    const val HOME = 1
    const val BOOKS = 2
    const val BASKET = 3
    const val SETTINGS = 4
    const val ABOUT = 5
  }
}
