package org.aibles.bookservice.controller;

import static org.aibles.bookservice.constants.ApiConstants.BOOK_API_URI;

import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.bookservice.dto.request.CreateBookRequest;
import org.aibles.bookservice.dto.request.UpdateBookRequest;
import org.aibles.bookservice.dto.response.BookResponse;
import org.aibles.bookservice.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(BOOK_API_URI)
@RequiredArgsConstructor
public class BookController {

  private final BookService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BookResponse create(@RequestBody @Valid CreateBookRequest request) {
    log.info("(create)name : {}", request.getName());
    return service.create(request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteById(@PathVariable("id")long id) {
    log.info("(deleteById)id : {}", id);
    service.deleteById(id);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public BookResponse getById(@PathVariable("id")long id) {
    log.info("(getById)id : {}", id);
    return service.getById(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<BookResponse> list() {
    log.info("(list)");
    return service.list();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public BookResponse update(@PathVariable("id")long id,@RequestBody @Valid UpdateBookRequest request) {
    log.info("(update)id : {}, name : {}", id, request.getName());
    return service.update(id, request);
  }
}
