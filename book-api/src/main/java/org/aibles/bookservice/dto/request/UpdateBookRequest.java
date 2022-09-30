package org.aibles.bookservice.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.aibles.bookservice.entity.Book;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateBookRequest extends CreateBookRequest {

  @NotNull(message = "BookId.NotNull.message")
  private Long bookId;

  public Book toBook(Book book) {
    Book bookUpdated = super.toBook();
    bookUpdated.setBookId(book.getBookId());
    bookUpdated.setIsActive(book.getIsActive());

    return bookUpdated;
  }
}
