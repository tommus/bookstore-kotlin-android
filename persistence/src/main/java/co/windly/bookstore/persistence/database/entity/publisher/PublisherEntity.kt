package co.windly.bookstore.persistence.database.entity.publisher

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "publishers")
data class PublisherEntity(

  @PrimaryKey
  @ColumnInfo(name = "id")
  var id: Long = 0L,

  @ColumnInfo(name = "name")
  var name: String = ""
)
