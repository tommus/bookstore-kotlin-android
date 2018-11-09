package co.windly.bookstore.domain.model

open class Book(

  var id: Long = 0L,

  var title: String = "",

  var author: Long = 0L,

  var publisher: Long = 0L,

  var publicationYear: Int = 0,

  var cover: String = ""
)
