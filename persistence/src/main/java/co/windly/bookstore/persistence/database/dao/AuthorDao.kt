package co.windly.bookstore.persistence.database.dao

import androidx.room.Dao
import co.windly.bookstore.persistence.database.entity.author.AuthorEntity

@Dao
abstract class AuthorDao : BaseDao<AuthorEntity>()
