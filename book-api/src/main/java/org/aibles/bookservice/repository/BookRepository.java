package org.aibles.bookservice.repository;

import java.util.List;
import org.aibles.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  Boolean existsByName(String name);

  List<Book> findBookByReleaseAtAfter(Integer time);
}
