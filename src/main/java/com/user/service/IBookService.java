package com.user.service;

import com.user.model.Book;
import java.util.List;
import java.util.Optional;

public interface IBookService {
    Book createBook (Book objBook);
    Optional<Book> findByIdBook (Long idBook);
    List<Book> findAllBooks ();
    Book updateBook (Book objBook);
    void deleteBook (Long objBook);
}
