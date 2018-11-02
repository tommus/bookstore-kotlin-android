package co.windly.bookstore.persistence.database.dao

import androidx.room.Dao
import co.windly.bookstore.persistence.database.entity.binding.BindingEntity

@Dao
abstract class BindingDao : BaseDao<BindingEntity>()
