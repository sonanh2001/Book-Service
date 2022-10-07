package org.aibles.bookservice.repository;

import java.awt.print.Pageable;
import java.util.List;
import org.aibles.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  Boolean existsByName(String name);
  @Query("select b from Book b where b.releaseAt > :time")
  List<Book> findReleaseBook(@Param("time")Integer time, Pageable pageable);
}
