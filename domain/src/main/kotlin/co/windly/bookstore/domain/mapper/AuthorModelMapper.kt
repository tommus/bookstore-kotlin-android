package co.windly.bookstore.domain.mapper

import co.windly.bookstore.domain.model.Author
import co.windly.bookstore.network.dto.response.author.AuthorDto
import co.windly.bookstore.persistence.database.entity.author.AuthorEntity
import org.modelmapper.ModelMapper

class AuthorModelMapper(private val mapper: ModelMapper) {

  //region AuthorDto -> Author

  fun mapAuthorDtoToModel(dto: AuthorDto): Author {
    return mapper.map(dto, Author::class.java)
  }

  fun mapAuthorDtosToModels(dtos: List<AuthorDto>): List<Author> {
    return dtos
      .asSequence()
      .map { mapAuthorDtoToModel(it) }
      .toList()
  }

  //endregion

  //region Author -> AuthorEntity

  fun mapAuthorModelToEntity(model: Author): AuthorEntity {
    return mapper.map(model, AuthorEntity::class.java)
  }

  fun mapAuthorModelsToEntities(models: List<Author>): List<AuthorEntity> {
    return models
      .asSequence()
      .map { mapAuthorModelToEntity(it) }
      .toList()
  }

  //endregion
}
