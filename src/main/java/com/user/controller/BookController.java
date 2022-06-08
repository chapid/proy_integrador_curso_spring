package com.user.controller;


import com.user.controller.dto.BookDto;
import com.user.model.Book;
import com.user.service.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/v1/books/")
public class BookController {

    private final IBookService objBookServices;

    public BookController(IBookService iBookService) {
        this.objBookServices = iBookService;
    }

    @PostMapping("")
    public Book createBook(@RequestBody BookDto objBookDto){
        return objBookServices.createBook(new Book(objBookDto));
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Book>> findAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(objBookServices.findAllBooks());
    }

    @GetMapping("{idBook}")
    public Optional<Book> findById(@PathVariable Long idBook){

        return objBookServices.findByIdBook(idBook);
    }

    @PutMapping("{objBook}")
    public Book updateBook(@RequestBody Book objBook){
        return objBookServices.updateBook(objBook);
    }

    @DeleteMapping("{idBook}")
    public void deleteBook(@PathVariable Long idBook){
        objBookServices.deleteBook(idBook);
    }
}

