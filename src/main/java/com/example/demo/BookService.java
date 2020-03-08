package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final EntityManager entityManager;
    @Transactional
    public int createBook(final BookEntity book) {
        BookEntity savedApartment = entityManager.merge(book);
        return savedApartment.getId();
    }

    @Transactional
    public List<BookEntity> findAllBooksWithoutFetch() {
        return entityManager.createQuery("FROM BookEntity", BookEntity.class)
                .getResultList();

    }

    @Transactional
    public List<BookEntity> findByName(String name) {
        return entityManager.createQuery("Select a FROM BookEntity a Where a.book_name = :nam").setParameter("nam", name).getResultList();

    }
    @Transactional
    public List<BookEntity> findByIsbn(String name) {
        return entityManager.createQuery("Select a FROM BookEntity a Where a.isbn = :nam").setParameter("nam", name).getResultList();

    }
    @Transactional
    public List<BookEntity> findByAuthor(String name) {
        return entityManager.createQuery("Select a FROM BookEntity a Where a.author = :nam").setParameter("nam", name).getResultList();

    }


    @Transactional
    public BookEntity getBookById(int bookId) {
        return entityManager.find(BookEntity.class, bookId);
    }

}
