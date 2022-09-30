package org.aibles.bookservice.dto.response;

import lombok.Data;
import org.aibles.bookservice.entity.Book;

@Data
public class BookResponse {
  private Long bookId;

  private String name;

  private String description;

  private Integer releaseAt;

  private Boolean isActive;

  public static BookResponse from(Book book) {
    BookResponse response = new BookResponse();
    response.setBookId(book.getBookId());
    response.setName(book.getName());
    response.setDescription(book.getDescription());
    response.setReleaseAt(book.getReleaseAt());
    response.setIsActive(book.getIsActive());

    return response;
  }
}
