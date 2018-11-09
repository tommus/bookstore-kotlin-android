package co.windly.bookstore.persistence.database.dao

import androidx.room.Dao
import co.windly.bookstore.persistence.database.entity.publisher.PublisherEntity

@Dao
abstract class PublisherDao : BaseDao<PublisherEntity>()
