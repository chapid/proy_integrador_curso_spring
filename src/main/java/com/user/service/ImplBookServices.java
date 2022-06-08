package com.user.service;

import com.user.model.Book;
import com.user.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ImplBookServices implements IBookService {

    private final IBookRepository objBookRepository;

    public ImplBookServices(@Autowired IBookRepository objBookRepository) {
        this.objBookRepository = objBookRepository;
    }

    @Override
    public Book createBook(Book objBook) {
        return objBookRepository.save(objBook);
    }

    @Override
    public Optional<Book> findByIdBook (Long idBook) {
        return objBookRepository.findById(idBook);
    }

    @Override
    public List<Book> findAllBooks() {
        return (List<Book>) objBookRepository.findAll();
    }

    @Override
    public Book updateBook(Book objBook) {
        //if (objBook.getIdBook() != 0 && objBookRepository.existsById(objBook.getIdBook())){
            return objBookRepository.save(objBook);
        //}
       // return null;
    }

    @Override
    public void deleteBook (Long idBook) {
        objBookRepository.deleteById(idBook);
    }
}
