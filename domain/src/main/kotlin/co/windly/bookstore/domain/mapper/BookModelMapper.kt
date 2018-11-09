package co.windly.bookstore.domain.mapper

import co.windly.bookstore.domain.model.Book
import co.windly.bookstore.domain.model.BookDetails
import co.windly.bookstore.network.dto.response.book.BookDetailsDto
import co.windly.bookstore.network.dto.response.book.BookDto
import co.windly.bookstore.persistence.database.entity.book.BookEntity
import org.modelmapper.ModelMapper

class BookModelMapper(private val mapper: ModelMapper) {

  //region BookDto -> Book

  fun mapBookDtoToModel(dto: BookDto): Book {
    return mapper.map(dto, Book::class.java)
  }

  fun mapBookDtosToModels(dtos: List<BookDto>): List<Book> {
    return dtos
      .asSequence()
      .map { mapBookDtoToModel(it) }
      .toList()
  }

  //endregion

  //region Book -> BookEntity

  fun mapBookModelToEntity(model: Book): BookEntity {
    return mapper.map(model, BookEntity::class.java)
  }

  fun mapBookModelsToEntities(models: List<Book>): List<BookEntity> {
    return models
      .asSequence()
      .map { mapBookModelToEntity(it) }
      .toList()
  }

  //endregion

  //region BookDetailsDto -> BookDetails

  fun mapBookDetailsDtoToModel(dto: BookDetailsDto): BookDetails {
    return mapper.map(dto, BookDetails::class.java)
  }

  fun mapBookDetailsDtosToModels(dtos: List<BookDetailsDto>): List<BookDetails> {
    return dtos
      .asSequence()
      .map { mapBookDetailsDtoToModel(it) }
      .toList()
  }

  //endregion

  //region BookDetails -> BookEntity

  fun mapBookDetailsModelToEntity(model: BookDetails): BookEntity {
    return mapper.map(model, BookEntity::class.java)
  }

  fun mapBookDetailsModelsToEntities(models: List<BookDetails>): List<BookEntity> {
    return models
      .asSequence()
      .map { mapBookDetailsModelToEntity(it) }
      .toList()
  }

  //endregion
}
