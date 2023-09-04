package ru.alexandr1017.service;


import org.springframework.stereotype.Service;
import ru.alexandr1017.model.Book;

import ru.alexandr1017.repository.BookRepo;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BookService {
    private final BookRepo bookRepo;


    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;

    }


    public Optional<Book> getBook(Integer id) {
        return bookRepo.findById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book addBook(Book book) {
        book.setCodeVendor(generateISBN());
        return bookRepo.save(book);
    }

    public void deleteBook(Book book) {
        bookRepo.delete(book);
    }




    private String generateISBN() {
        Random rand = new Random();
        int[] digits = new int[13];
        for (int i = 0; i < 12; i++) {
            digits[i] = rand.nextInt(10);
        }
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            if (i % 2 == 0) {
                sum += digits[i];
            } else {
                sum += digits[i] * 3;
            }
        }
        digits[12] = (10 - sum % 10) % 10;
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        return sb.toString();
    }


}
