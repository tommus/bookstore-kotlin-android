package co.windly.bookstore.domain.mapper

import co.windly.bookstore.domain.model.Binding
import co.windly.bookstore.network.dto.response.binding.BindingDto
import co.windly.bookstore.persistence.database.entity.binding.BindingEntity
import org.modelmapper.ModelMapper

class BindingModelMapper(private val mapper: ModelMapper) {

  //region BindingDto -> Binding

  fun mapBindingDtoToModel(dto: BindingDto): Binding {
    return mapper.map(dto, Binding::class.java)
  }

  fun mapBindingDtosToModels(dtos: List<BindingDto>): List<Binding> {
    return dtos
      .asSequence()
      .map { mapBindingDtoToModel(it) }
      .toList()
  }

  //endregion

  //region Binding -> BindingEntity

  fun mapBindingModelToEntity(model: Binding): BindingEntity {
    return mapper.map(model, BindingEntity::class.java)
  }

  fun mapBindingModelsToEntities(models: List<Binding>): List<BindingEntity> {
    return models
      .asSequence()
      .map { mapBindingModelToEntity(it) }
      .toList()
  }

  //endregion
}
