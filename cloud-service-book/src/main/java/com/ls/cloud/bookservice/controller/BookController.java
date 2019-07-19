package com.ls.cloud.bookservice.controller;

import com.ls.cloud.bookservice.entity.BookCatalog;
import com.ls.cloud.bookservice.entity.BookChapter;
import com.ls.cloud.bookservice.entity.MyBook;
import com.ls.cloud.bookservice.entity.rep.Code;
import com.ls.cloud.bookservice.entity.rep.DataResponse;
import com.ls.cloud.bookservice.service.BookService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;


/**
 * @author liang
 */
@RestController(value = "/book")
@Api(value = "Book APIs", description = "小说API")
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "根据OpenID查询他的书架")
    @ApiImplicitParam(value = "用户的openId", name = "openId", dataType = "String", paramType = "path", required = true)
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 1, message = "失败")
    })
    @GetMapping(value = "/myBook/{openId}")
    public DataResponse myBook(@PathVariable String openId) {
        List<BookCatalog> bookCatalogs = bookService.queryMyBookByOpenId(openId);
        return DataResponse.of(bookCatalogs);
    }

    @ApiOperation(value = "将书籍加入书架")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户的openId", name = "openId", dataType = "String", paramType = "path", required = true),
            @ApiImplicitParam(value = "书籍ID", name = "bookId", dataType = "int", paramType = "path", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 1, message = "失败")
    })
    @GetMapping(value = "/addBook/{openId}/{bookId}")
    public DataResponse addBook(@PathVariable String openId, @PathVariable int bookId) {
        MyBook myBook = new MyBook();
        myBook.setBookId(bookId);
        myBook.setOpenId(openId);
        BookCatalog bookCatalog = bookService.queryBookCatalog(bookId);
        myBook.setBookAuthor(bookCatalog.getAuthor());
        myBook.setBookName(bookCatalog.getName());
        bookService.addBook(myBook);
        return DataResponse.SUCCESS();
    }

    @ApiOperation(value = "将书籍移除书架")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户的openId", name = "openId", dataType = "String", paramType = "path", required = true),
            @ApiImplicitParam(value = "书籍ID", name = "bookId", dataType = "int", paramType = "path", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 1, message = "失败")
    })
    @GetMapping(value = "/removeBook/{openId}/{bookId}")
    public DataResponse removeBook(@PathVariable String openId, @PathVariable int bookId) {
        bookService.removeBook(openId, bookId);
        return DataResponse.SUCCESS();
    }


    @ApiOperation(value = "根据OpenID更新书架上的书籍")
    @ApiImplicitParam(value = "用户的openId", name = "openId", dataType = "String", paramType = "path", required = true)
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 1, message = "失败")
    })
    @GetMapping(value = "/updateMyBook/{openId}")
    public DataResponse updateMyBook(@PathVariable String openId) {
        List<BookCatalog> bookCatalogs = bookService.queryMyBookByOpenId(openId);
        bookCatalogs.stream().forEach(e ->
                bookService.updateBookChapter(e));
        return DataResponse.SUCCESS();
    }

    @ApiOperation(value = "获取章节列表")
    @ApiImplicitParam(value = "bookId", name = "bookId", dataType = "int", paramType = "path", required = true)
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 1, message = "失败")
    })
    @GetMapping(value = "/bookChapter/{bookId}")
    public DataResponse bookChapter(@PathVariable int bookId) {
        List<BookChapter> bookChapters = bookService.queryBookChapters(bookId);
        return DataResponse.of(bookChapters);
    }


    @ApiOperation(value = "获取章节内容")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "书籍ID", name = "bookId", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(value = "书籍排序", name = "order", dataType = "int", paramType = "path", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 1, message = "失败")
    })
    @GetMapping(value = "/bookContent/{bookId}/{order}")
    public DataResponse bookContent(@PathVariable int bookId, @PathVariable int order) {
        BookChapter bookChapter = bookService.queryBookChapter(bookId, order);
        return DataResponse.of(Code.SUCCESS, bookChapter, "success");
    }

    @ApiOperation(value = "更新书籍目录")
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 1, message = "失败")
    })
    @GetMapping(value = "/updateBookCatalog")
    public DataResponse updateBookCatalog() {
        bookService.getUrlFromSite(1);
        return DataResponse.SUCCESS();
    }


    @ApiOperation(value = "更新此书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "书籍ID", name = "bookId", dataType = "int", paramType = "path", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 1, message = "失败")
    })
    @GetMapping(value = "/updateBookChapters/{bookId}")
    public DataResponse updateBookChapters(@PathVariable int bookId) {
        BookCatalog bookCatalog = bookService.queryBookCatalog(bookId);
        bookService.updateBookChapter(bookCatalog);
        return DataResponse.SUCCESS();
    }


    @ApiOperation(value = "更新此书籍此章节")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "书籍ID", name = "bookId", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(value = "书籍排序", name = "order", dataType = "int", paramType = "path", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 1, message = "失败")
    })
    @GetMapping(value = "/updateBookChapter/{bookId}/{order}")
    public DataResponse updateBookChapter(@PathVariable int bookId, @PathVariable int order) {
        BookChapter bookChapter = bookService.queryBookChapter(bookId, order);
        bookService.getChapterContenmt(bookChapter.getUrl());
        bookService.updateBookChapterContent(bookChapter);
        return DataResponse.of(Code.SUCCESS, bookChapter, "");
    }

}
