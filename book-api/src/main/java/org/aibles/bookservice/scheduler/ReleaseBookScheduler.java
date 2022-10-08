package org.aibles.bookservice.scheduler;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.bookservice.entity.Book;
import org.aibles.bookservice.service.BookService;
import org.aibles.bookservice.util.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReleaseBookScheduler {

  private final BookService service;
  @Value("${application.book_scheduler.release_book.enable:true}")
  private Boolean enable;

  @Value("${application.book_scheduler.release_book.size:500}")
  private int size;

  @Scheduled(cron = "${application.book_scheduler.release_book.cron:0 0 0 * * ?}")
  @Transactional
  public void execute() {
    log.info("(execute)enable : {}, size : {}", enable, size);
    if(!enable) {
      return;
    }
    try {
      while(true) {
        int page = 0;
        List<Book> books = service.handleReleaseBook(DateUtil.convertLocalDateTimeToInteger(
            LocalDateTime.now()), page, size);
        if(books.size() < size) {
          break;
        }
        page++;
      }
    } catch (Exception e) {
      log.error("exception : {}", e.getMessage());
    }
  }
}
