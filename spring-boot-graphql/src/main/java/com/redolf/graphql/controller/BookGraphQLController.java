package com.redolf.graphql.controller;

import com.redolf.graphql.model.Book;
import com.redolf.graphql.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookGraphQLController {

    private final BookService service;

    public BookGraphQLController(BookService service) {
        this.service = service;
    }

    @QueryMapping
    private List<Book> findAllBooks (){
        return service.findAllBooks();
    }


    @MutationMapping
    private Book saveBook(@Argument(name = "input") Book input){
        return service.saveBook(input);
    }

    private Book updateBook (@PathVariable int bookId , @RequestBody Book book){
        return service.updateById(bookId, book);
    }

    @MutationMapping
    private Book deleteBook (@Argument("id") int bookId){
        return service.deleteById(bookId);
    }

    @QueryMapping
    private Optional<Book> findBookById(@Argument(name = "id") int bookId){
        return service.findById(bookId);
    }
}

