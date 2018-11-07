package co.windly.bookstore.presentation.main.book.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import co.windly.bookstore.R
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.fragment_book_list.recyclerView
import kotlinx.android.synthetic.main.fragment_book_list.swipeRefresh

typealias BookListIItem = IItem<*, *>

class BookListFragment : Fragment() {

  //region Ui

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_book_list, container, false)
  }

  //endregion

  //region Lifecycle

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    // TODO:
    initializeSwipeRefresh()
    initializeRecyclerView()
  }

  //endregion

  //region Swipe Refresh

  private fun initializeSwipeRefresh() {
    swipeRefresh.setOnRefreshListener {
      // TODO:
    }
  }

  //endregion

  //region Recycler View

  private lateinit var fastItemAdapter: FastItemAdapter<BookListIItem>

  private fun initializeRecyclerView() {

    // Create fast adapter.
    fastItemAdapter = FastItemAdapter()
    fastItemAdapter.withSelectable(true)

    // Configure recycler view.
    with(recyclerView) {
      layoutManager = provideLayoutManager()
      setHasFixedSize(true)
      adapter = fastItemAdapter
    }
  }

  //endregion

  //region Layout Manager

  private fun provideLayoutManager(): LayoutManager = LinearLayoutManager(requireContext())

  //endregion
}
