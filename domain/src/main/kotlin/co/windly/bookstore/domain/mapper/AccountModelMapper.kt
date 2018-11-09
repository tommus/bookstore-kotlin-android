package co.windly.bookstore.domain.mapper

import co.windly.bookstore.network.dto.response.account.LoginDto
import org.modelmapper.ModelMapper

class AccountModelMapper(private val mapper: ModelMapper) {

  //region LoginDto -> Access Token

  fun mapLoginDtoToModel(dto: LoginDto): String {
    return dto.accessToken
  }

  //endregion
}