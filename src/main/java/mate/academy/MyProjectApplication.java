package mate.academy;

import java.math.BigDecimal;
import mate.academy.model.Book;
import mate.academy.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(BookService bookService) {
        return args -> {
            Book book = new Book();
            book.setTitle("The Hobbit");
            book.setAuthor("J.R.R. Tolkien");
            book.setIsbn("9780007525492");
            book.setPrice(BigDecimal.valueOf(299));
            book.setDescription("Fantasy novel");
            book.setCoverImage("cover.jpg");

            bookService.save(book);
        };
    }
}
