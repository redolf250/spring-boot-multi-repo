package com.redolf.graphql.service;

import com.redolf.graphql.model.Book;
import com.redolf.graphql.model.Genre;
import jakarta.annotation.PostConstruct;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookService {

    private final List<Book> database = new ArrayList<>();

    @PostConstruct
    public  void init(){
        database.add(new Book(id.incrementAndGet(), "The Great Gatsby", "United States", "publisher@example.com", "Fiction"));
        database.add(new Book(id.incrementAndGet(), "To Kill a Mockingbird", "United States", "publisher@example.com", "Fiction"));
        database.add(new Book(id.incrementAndGet(), "1984", "United Kingdom", "publisher@example.com", "Science Fiction"));
        database.add(new Book(id.incrementAndGet(), "Harry Potter and the Sorcerer's Stone", "United Kingdom", "publisher@example.com", "Fantasy"));
        database.add(new Book(id.incrementAndGet(), "The Catcher in the Rye", "United States", "publisher@example.com", "Fiction"));
        database.add(new Book(id.incrementAndGet(), "The Hobbit", "United Kingdom", "publisher@example.com", "Fantasy"));
        database.add(new Book(id.incrementAndGet(), "Pride and Prejudice", "United Kingdom", "publisher@example.com", "Romance"));
        database.add(new Book(id.incrementAndGet(), "The Lord of the Rings", "United Kingdom", "publisher@example.com", "Fantasy"));
        database.add(new Book(id.incrementAndGet(), "Animal Farm", "United Kingdom", "publisher@example.com", "Fiction"));
        database.add(new Book(id.incrementAndGet(), "The Da Vinci Code", "United States", "publisher@example.com", "Thriller"));
    }

    private AtomicInteger id = new AtomicInteger(0);

    public List<Book> findAllBooks(){
        return database.stream().toList();
    }

    public Optional<Book> findById(int id){
        return database.stream().filter(book -> book.id()==id).findFirst();
    }

    public Book deleteById(int id){
        Book first = database
                .stream()
                .filter(book -> book.id() == id)
                .findFirst()
                .orElseThrow(() -> new  IllegalArgumentException());
        database.remove(first);
        return first;
    }

    public Book updateById(int id, Book book){
        Optional<Book> first = database.stream().filter(book1 -> book1.id() == id).findFirst();
        if (first.isEmpty()){
            Book book1 = first.get();
            int index = database.indexOf(book1);
            database.set(index, book);
        }else {
            throw new IllegalArgumentException();
        }
        return book;
    }

    public Book saveBook(Book book){
        Book record = new Book(id.incrementAndGet(), book.name(), book.contact(), book.country(), book.genre());
        database.add(record);
        return record;
    }


    public Book CreateBook(List<String> properties) {
        Book record = new Book(id.incrementAndGet(), properties.get(0), properties.get(1), properties.get(2), properties.get(3));
        database.add(record);
        return record;
    }

}
