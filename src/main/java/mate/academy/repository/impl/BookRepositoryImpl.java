package mate.academy.repository.impl;

import java.util.List;
import mate.academy.model.Book;
import mate.academy.repository.BookRepository;
import mate.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BookRepositoryImpl
        extends mate.academy.hibernate.relations.dao.impl.AbstractDao
        implements BookRepository {
    public BookRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
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
            throw new RuntimeException("Can't insert actor: " + book, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List findAll() {
        List<Book> books;
        try (Session session = factory.openSession()) {
            books = session.createQuery("FROM Book", Book.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't get all books", e);
        }
        return books;
    }
}
