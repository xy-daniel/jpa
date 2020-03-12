package org.javaboy.jpa;

import org.javaboy.jpa.bean.Book;
import org.javaboy.jpa.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class JpaApplicationTests {

    @Autowired
    BookDao bookDao;

    //普通查询
    @Test
    void findAll() {
//        System.out.println(bookDao.findAll());
        System.out.println(bookDao.findById(2));
    }

    //排序查询
    @Test
    void findAll2() {
        System.out.println(bookDao.findAll(Sort.by("id").descending()));
    }

    //分页查询
    @Test
    void findAll3() {
        Pageable pageable = PageRequest.of(0, 2);
        Page<Book> page = bookDao.findAll(pageable);
        System.out.println("总记录数："+page.getTotalElements());
        System.out.println("当前页记录数："+page.getNumberOfElements());
        System.out.println("每页记录数："+page.getSize());
        System.out.println("总页数"+page.getTotalPages());
        List<Book> content = page.getContent();
        System.out.println("查询结果："+ content);
        System.out.println("当前页数（从0开始计算）："+page.getNumber());
        System.out.println("是否为首页："+page.isFirst());
        System.out.println("是否为末页："+page.isLast());
    }

    @Test
    void findBookById(){
        System.out.println(bookDao.findBookById(2));
    }

    @Test
    void findBooksByIdGreaterThanEqual(){
        System.out.println(bookDao.findBooksByIdGreaterThanEqual(2));
    }

    @Test
    void findBookByIdLessThanEqual(){
        System.out.println(bookDao.findBookByIdLessThanEqual(2));
    }

    @Test
    void save() {
        Book save = bookDao.save(new Book("name", "author"));
        System.out.println(save);
    }

    @Test
    void getMaxIdBook(){
        Book maxIdBook = bookDao.getMaxIdBook();
        System.out.println(maxIdBook);
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

    @Test
    void addBook(){
        System.out.println(bookDao.addBook0("鲁迅0", "朝花夕拾0"));
        System.out.println(bookDao.addBook("鲁迅1", "朝花夕拾1"));
    }

}
