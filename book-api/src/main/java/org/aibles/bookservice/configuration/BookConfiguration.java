package org.aibles.bookservice.configuration;

import org.aibles.bookservice.repository.BookRepository;
import org.aibles.bookservice.service.BookService;
import org.aibles.bookservice.service.impl.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"org.aibles.bookservice.repository"})
@EnableJpaRepositories(basePackages = {"org.aibles.bookservice.repository"})
public class BookConfiguration {
  @Bean
  public BookService bookService(BookRepository repository) {
    return new BookServiceImpl(repository);
  }
}
