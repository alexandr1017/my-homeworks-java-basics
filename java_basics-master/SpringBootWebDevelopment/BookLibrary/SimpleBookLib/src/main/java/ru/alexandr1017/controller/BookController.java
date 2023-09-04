package ru.alexandr1017.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import ru.alexandr1017.exception.NotFoundBookException;
import ru.alexandr1017.model.Book;

import ru.alexandr1017.service.BookService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RestController
@RequestMapping("books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> showBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Integer id) throws NotFoundBookException {
        Book book = bookService.getBook(id).orElseThrow(() -> new NotFoundBookException("Book not found ! id: " + id));
        return ResponseEntity.ok().body(book);
    }


    @PostMapping
    public Book addBook(@Valid @RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Integer id, @Valid @RequestBody Book bookDetails) throws NotFoundBookException {
        Book book = bookService.getBook(id).orElseThrow(() -> new NotFoundBookException("Can't update! Book not found ! id: " + id));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setCountOfPages(bookDetails.getCountOfPages());
        book.setPublicationYear(bookDetails.getPublicationYear());
        book.setPrice(bookDetails.getPrice());

        final  Book updateBook = bookService.addBook(book);
        return ResponseEntity.ok(updateBook);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer id)
            throws NotFoundBookException {
        Book book = bookService.getBook(id)
                .orElseThrow(() -> new NotFoundBookException("Can't DELETE! Book not found ! id: " + id));

        bookService.deleteBook(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
