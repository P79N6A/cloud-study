package com.ls.cloud.bookservice.dao;


import com.ls.cloud.bookservice.entity.BookCatalog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookCatalogDao {

    int insertOrUpdate(BookCatalog bookCatalog);

    BookCatalog queryBookCatalog(@Param("bookId") int bookId);
}
