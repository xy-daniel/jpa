package org.javaboy.jpa.dao;

import org.javaboy.jpa.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
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

    /**
     * 自定义数据修改的SQL
     * @param name  书籍名称
     * @param author  书籍作者
     * @return  受影响行数值
     */
    @Query(value = "insert into t_book(name, author) values(?1,?2)", nativeQuery = true)
    @Modifying
    @Transactional
    Integer addBook0(String name, String author);

    @Query(value = "insert into t_book(name, author) values(:name,:author)", nativeQuery = true)
    @Modifying
    @Transactional
    Integer addBook(@Param("name") String name, @Param("author") String author);
}
