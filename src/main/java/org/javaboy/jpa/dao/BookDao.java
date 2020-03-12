package org.javaboy.jpa.dao;

import org.javaboy.jpa.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {
    /**
     * 自定义方法基本可以满足绝大多数情形
     * @param id 主键
     * @return  Book
     */
    Book findBookById(Integer id);
    List<Book> findBooksByIdGreaterThanEqual(Integer id);
    List<Book> findBookByIdLessThanEqual(Integer id);

    /**
     * 自定义查询SQL
     * @return Book
     */
    @Query(value = "select * from t_book where id= (select max(id) from t_book)", nativeQuery = true)
    Book getMaxIdBook();
}
