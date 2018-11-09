package co.windly.bookstore.persistence.database.entity.binding

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bindings")
data class BindingEntity(

  @PrimaryKey
  @ColumnInfo(name = "id")
  var id: Long = 0L,

  @ColumnInfo(name = "description")
  var description: String = ""
)
