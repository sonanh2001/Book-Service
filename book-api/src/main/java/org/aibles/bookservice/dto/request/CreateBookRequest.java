package org.aibles.bookservice.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.aibles.bookservice.entity.Book;

@Data
public class CreateBookRequest {

  @NotBlank(message = "Name.NotBlank.message")
  private String name;

  @NotBlank(message = "Description.NotBlank.message")
  private String description;

  @NotNull(message = "ReleaseAt.NotNull.message")
  private Integer releaseAt;

  public Book toBook() {
    Book book = new Book();
    book.setName(this.getName());
    book.setDescription(this.getDescription());
    book.setReleaseAt(this.getReleaseAt());
    return book;
  }
}
