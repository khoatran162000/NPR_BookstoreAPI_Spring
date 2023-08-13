package com.npr.bookstorerestapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.npr.bookstorerestapi.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	@RestResource(path = "categoryid")
	Page<Book> findByCategoryId(@Param("id") Integer id, Pageable pageable);

	@RestResource(path = "searchbykeyword")
	Page<Book> findByNameContaining(@Param("name") String keyword, Pageable pageable);
}
