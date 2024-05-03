package com.redolf.graphql.controller;

import com.redolf.graphql.model.Book;
import com.redolf.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BooksController {
    private final BookService service;

    public BooksController(BookService service) {
        this.service = service;
    }

    @GetMapping("/books")
    private List<Book> books (){
        return service.findAllBooks();
    }

    @PostMapping("/book")
    private Book saveBook (@RequestBody Book book){
        return service.saveBook(book);
    }
    @PutMapping("/book/{bookId}")
    private Book updateBook (@PathVariable int bookId ,@RequestBody Book book){
        return service.updateById(bookId, book);
    }

    @DeleteMapping("/book/{bookId}")
    private Book updateBook (@PathVariable int bookId){
        return service.deleteById(bookId);
    }
}
