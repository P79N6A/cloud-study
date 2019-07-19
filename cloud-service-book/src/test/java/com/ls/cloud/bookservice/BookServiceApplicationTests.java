package com.ls.cloud.bookservice;

import com.ls.cloud.bookservice.entity.BookCatalog;
import com.ls.cloud.bookservice.entity.BookChapter;
import com.ls.cloud.bookservice.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    public void contextLoads() {
        bookService.getUrlFromSite(1);
    }

    @Test
    public void test1(){
        List<BookCatalog> bookCatalogs = bookService.queryMyBookByOpenId("1");
        bookCatalogs.stream().forEach(e-> {
            bookService.updateBookChapter(e);
        });
        System.out.println(bookCatalogs.toString());
    }


    @Test
    public void test2(){
        List<BookChapter> bookChapters = bookService.queryBookChapters(25141);
        System.out.println(bookChapters.toString());
    }
}
