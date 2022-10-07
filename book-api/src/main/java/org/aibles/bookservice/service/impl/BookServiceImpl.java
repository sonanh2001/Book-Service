package org.aibles.bookservice.service.impl;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.bookservice.dto.request.CreateBookRequest;
import org.aibles.bookservice.dto.request.UpdateBookRequest;
import org.aibles.bookservice.dto.response.BookResponse;
import org.aibles.bookservice.entity.Book;
import org.aibles.bookservice.repository.BookRepository;
import org.aibles.bookservice.service.BookService;
import org.aibles.bookservice.util.DateUtil;
import org.aibles.coreexception.exception.ExistedException;
import org.aibles.coreexception.exception.NotFoundException;
import org.aibles.coreexceptionapi.configuration.EnableExceptionHandler;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@EnableExceptionHandler
public class BookServiceImpl implements BookService {

  private static final String BOOK_ID_FIELD = "bookId";
  private static final String BOOK_NAME_FIELD = "name";
  private static final String BOOK_TYPE = "book";
  private final BookRepository repository;

  @Override
  @Transactional
  public BookResponse create(CreateBookRequest request) {
    log.info("(create)name : {}", request.getName());
    if (repository.existsByName(request.getName())) {
      throw new ExistedException(BOOK_NAME_FIELD, request.getName(), BOOK_TYPE);
    }
    Book book = request.toBook();
    book.setIsActive(
        book.getReleaseAt() <= DateUtil.convertLocalDateTimeToInteger(LocalDateTime.now()));
    return BookResponse.from(repository.save(book));
  }

  @Override
  @Transactional
  public List<Book> handleReleaseBook(Integer time, int page, int size) {
    log.info("(handleReleaseBook)time : {}, page : {}, size : {}", time, page, size);
    Pageable pageable = (Pageable) PageRequest.of(page, size);
    List<Book> books = repository.findReleaseBook(time, pageable);
    books = books.parallelStream().peek(book -> book.setIsActive(true)).collect(Collectors.toList());
    books = repository.saveAll(books);
    return books;
  }

  @Override
  @Transactional
  public void deleteById(long id) {
    log.info("(deleteById)id : {}", id);
    if (repository.existsById(id)) {
      throw new NotFoundException(BOOK_ID_FIELD, id, BOOK_TYPE);
    }
    repository.deleteById(id);
  }

  @Override
  @Transactional
  public BookResponse getById(long id) {
    log.info("(getById)id : {}", id);
    return repository
        .findById(id)
        .map(BookResponse::from)
        .orElseThrow(() -> new NotFoundException(BOOK_ID_FIELD, id, BOOK_TYPE));
  }

  @Override
  @Transactional
  public List<BookResponse> list() {
    log.info("(list)");
    return repository.findAll().stream().map(BookResponse::from).collect(Collectors.toList());
  }

  @Override
  @Transactional
  public BookResponse update(long id, UpdateBookRequest request) {
    log.info("(update)id : {}, name : {}", id, request.getName());
    Book book =
        repository
            .findById(id)
            .map(request::toBook)
            .orElseThrow(() -> new NotFoundException(BOOK_ID_FIELD, id, BOOK_TYPE));
    return BookResponse.from(repository.save(book));
  }
}
