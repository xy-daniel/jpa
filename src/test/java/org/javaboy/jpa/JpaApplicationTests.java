package org.javaboy.jpa;

import org.javaboy.jpa.bean.Book;
import org.javaboy.jpa.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaApplicationTests {

    @Autowired
    BookDao bookDao;

    @Test
    void findAll() {
//        System.out.println(bookDao.findAll());
        System.out.println(bookDao.findById(2));
    }

    @Test
    void save() {
        Book save = bookDao.save(new Book("name", "author"));
        System.out.println(save);
    }

    @Test
    void update() {
        Book save = bookDao.save(new Book(1,"nameUpdate", "author"));
        System.out.println(save);
    }

    @Test
    void delete() {
        bookDao.deleteById(1);
    }

}
