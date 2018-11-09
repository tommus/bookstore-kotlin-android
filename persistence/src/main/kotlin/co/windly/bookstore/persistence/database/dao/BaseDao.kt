package co.windly.bookstore.persistence.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

abstract class BaseDao<Entity> {

  //region Insert

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  abstract fun insert(entity: Entity): Long

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  abstract fun insert(entities: Iterable<Entity>)

  //endregion

  //region Update

  @Update(onConflict = OnConflictStrategy.REPLACE)
  abstract fun update(entity: Entity)

  //endregion

  //region Removed

  @Delete
  abstract fun remove(entity: Entity)

  @Delete
  abstract fun remove(entities: Iterable<Entity>)

  //endregion
}
