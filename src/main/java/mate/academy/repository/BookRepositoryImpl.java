package mate.academy.repository.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.exception.DataProcessingException;
import mate.academy.model.Book;
import mate.academy.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final SessionFactory sessionFactory;

    public Book save(Book book) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert book: " + book, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Book> findAll() {
        List<Book> books;
        try (Session session = sessionFactory.openSession()) {
            books = session.createQuery("FROM Book", Book.class).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all books", e);
        }
        return books;
    }
}
