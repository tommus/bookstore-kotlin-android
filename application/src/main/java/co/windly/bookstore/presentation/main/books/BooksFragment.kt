package co.windly.bookstore.presentation.main.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.windly.bookstore.R

class BooksFragment : Fragment() {

  //region Lifecycle

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_books, container, false)
  }

  //endregion
}