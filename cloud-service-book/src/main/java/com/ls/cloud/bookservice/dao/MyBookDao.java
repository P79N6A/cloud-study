package com.ls.cloud.bookservice.dao;

import com.ls.cloud.bookservice.entity.BookCatalog;
import com.ls.cloud.bookservice.entity.MyBook;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MyBookDao {

    List<BookCatalog> queryMyBookByOpenId(@Param("openId") String openId);

    int addBook(MyBook myBook);

    void removeBook(@Param("openId") String openId, @Param("bookId") int bookId);
}
