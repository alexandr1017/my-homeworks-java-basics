package ru.alexandr1017.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexandr1017.model.Book;
@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {
}
