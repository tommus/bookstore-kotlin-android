package co.windly.bookstore.domain.mapper

import co.windly.bookstore.domain.model.Publisher
import co.windly.bookstore.network.dto.response.publisher.PublisherDto
import co.windly.bookstore.persistence.database.entity.publisher.PublisherEntity
import org.modelmapper.ModelMapper

class PublisherModelMapper(private val mapper: ModelMapper) {

  //region PublisherDto -> Publisher

  fun mapPublisherDtoToModel(dto: PublisherDto): Publisher {
    return mapper.map(dto, Publisher::class.java)
  }

  fun mapPublisherDtosToModels(dtos: List<PublisherDto>): List<Publisher> {
    return dtos
      .asSequence()
      .map { mapPublisherDtoToModel(it) }
      .toList()
  }

  //endregion

  //region Publisher -> PublisherEntity

  fun mapPublisherModelToEntity(model: Publisher): PublisherEntity {
    return mapper.map(model, PublisherEntity::class.java)
  }

  fun mapPublisherModelsToEntities(models: List<Publisher>): List<PublisherEntity> {
    return models
      .asSequence()
      .map { mapPublisherModelToEntity(it) }
      .toList()
  }

  //endregion
}
