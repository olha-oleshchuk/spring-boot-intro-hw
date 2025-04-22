package mate.academy.repository.impl;

import java.util.List;
import mate.academy.exception.DataProcessingException;
import mate.academy.model.Book;
import mate.academy.repository.BookRepository;
import mate.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BookRepositoryImpl implements BookRepository {
    protected final SessionFactory factory;

    public BookRepositoryImpl(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }

    public Book save(Book book) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't insert book: " + book, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Book> findAll() {
        List<Book> books;
        try (Session session = factory.openSession()) {
            books = session.createQuery("FROM Book", Book.class).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all books", e);
        }
        return books;
    }
}
