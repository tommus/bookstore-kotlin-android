package co.windly.bookstore.persistence.database.entity.author

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authors")
data class AuthorEntity(

  @PrimaryKey
  @ColumnInfo(name = "id")
  var id: Long = 0L,

  @ColumnInfo(name = "first_name")
  var firstName: String = "",

  @ColumnInfo(name = "last_name")
  var lastName: String = ""
)
