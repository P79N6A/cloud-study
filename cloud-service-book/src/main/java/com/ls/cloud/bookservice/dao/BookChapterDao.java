package com.ls.cloud.bookservice.dao;

import com.ls.cloud.bookservice.entity.BookChapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface BookChapterDao {

    void createIfNotExist(@Param("table_name") String table_name);

    void insertOrUpdate(BookChapter bookChapter);

    List<BookChapter> queryBookChapters(@Param("bookId") int bookId);

    BookChapter queryBookChapter(@Param("bookId") int bookId, @Param("order") int order);
}
