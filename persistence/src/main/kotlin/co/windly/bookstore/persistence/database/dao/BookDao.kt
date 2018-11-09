package co.windly.bookstore.persistence.database.dao

import androidx.room.Dao
import co.windly.bookstore.persistence.database.entity.book.BookEntity

@Dao
abstract class BookDao : BaseDao<BookEntity>()
