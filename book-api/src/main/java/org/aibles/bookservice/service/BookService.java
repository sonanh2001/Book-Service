package org.aibles.bookservice.service;

import java.util.List;
import org.aibles.bookservice.dto.request.CreateBookRequest;
import org.aibles.bookservice.dto.request.UpdateBookRequest;
import org.aibles.bookservice.dto.response.BookResponse;

public interface BookService {

  /**
   * create new book in database
   * @param request - request from client
   * @return - a book saved in database
   */
  BookResponse create(CreateBookRequest request);

  /**
   * delete a book by id
   * @param id - id sent from client
   */
  void deleteById(long id);

  /**
   * get a book by id
   * @param id - id sent from client
   * @return - a response of an book
   */
  BookResponse getById(long id);

  /**
   * list all book in database
   * @return - a list of books
   */
  List<BookResponse> list();

  /**
   * update a book by id
   * @param id - id sent from client
   * @param request - request of update book from client
   * @return - a response of updated book
   */
  BookResponse update(long id, UpdateBookRequest request);
}
