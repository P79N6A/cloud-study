package com.ls.cloud.bookservice.service;

import com.ls.cloud.bookservice.dao.BookCatalogDao;
import com.ls.cloud.bookservice.dao.BookChapterDao;
import com.ls.cloud.bookservice.dao.MyBookDao;
import com.ls.cloud.bookservice.entity.BookCatalog;
import com.ls.cloud.bookservice.entity.BookChapter;
import com.ls.cloud.bookservice.entity.BookSource;
import com.ls.cloud.bookservice.entity.MyBook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import java.io.IOException;
import java.util.List;

@Service
public class BookService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BookCatalogDao bookCatalogDao;

    @Autowired
    private BookChapterDao bookChapterDao;

    @Autowired
    private MyBookDao myBookDao;

    /**
     * 获取目录列表 url
     *
     * @throws IOException
     */
    public void getUrlFromSite(@Min(value = 1) int start) {
        logger.info("book updateBookCatalog");
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.23us.so/top/allvote_1.html").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element page = doc.selectFirst("#pagestats");
        String value = page.text();
        String[] split = value.split("/");
        if (split.length == 2) {
            int all_page = Integer.parseInt(split[1]);
            for (int i = start; i < all_page; i++) {
                logger.info("curent page:" + String.format("https://www.23us.so/top/allvote_%d.html", i));
                BookSource bookSource = new BookSource();
                bookSource.setName("顶点小说网");
                bookSource.setUrl(String.format("https://www.23us.so/top/allvote_%d.html", i));
                updateBookCatalog(bookSource);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取当前页的书籍
     *
     * @param bookSource
     * @throws IOException
     */
    public void updateBookCatalog(BookSource bookSource) {
        Document doc = null;
        try {
            doc = Jsoup.connect(bookSource.getUrl()).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements select = doc.select("tr[bgcolor='#FFFFFF']");

        BookCatalog bookCatalog = null;
        for (Element element : select) {
            Elements td = element.select("td");
            Element td0 = td.get(0);
            String book_name = td0.selectFirst("a").text();
            String book_url = td0.selectFirst("a").attr("href");
            Element td1 = td.get(1);
            String book_last_name = td1.selectFirst("a").text();
            if (book_last_name.length() > 60) {
                book_last_name = book_last_name.substring(0, 59);
            }
            String book_last_url = td1.selectFirst("a").attr("href");
            Element td2 = td.get(2);
            String book_author = td2.text();
            if (book_author.length() > 20) {
                book_author = book_author.substring(0, 19);
            }
            Element td3 = td.get(3);
            String book_size = td3.text();
            Element td4 = td.get(4);
            String book_last_update = "20" + td4.text();
            Element td5 = td.get(5);
            String book_status = td5.text();

            bookCatalog = new BookCatalog();
            bookCatalog.setName(book_name);
            bookCatalog.setUrl(book_url);
            bookCatalog.setAuthor(book_author);
            bookCatalog.setSize(book_size);
            bookCatalog.setLastUpdate(book_last_update);
            bookCatalog.setLastName(book_last_name);
            bookCatalog.setLastUrl(book_last_url);
            bookCatalog.setStatus(book_status);

            int id = bookCatalogDao.insertOrUpdate(bookCatalog);
            bookCatalog.setId(id);

        }
    }

    /**
     * 获取书籍的所有章节
     */
    public void updateBookChapter(BookCatalog bookCatalog) {
        String table_name = "book_" + bookCatalog.getId();

        bookChapterDao.createIfNotExist(table_name);
        Document doc = null;
        try {
            doc = Jsoup.connect(bookCatalog.getLastUrl()).get();
        } catch (IOException e) {
            logger.error("获取书籍失败" + e.fillInStackTrace());
        }
        Elements select = doc.select("#at tr td");
        BookChapter bookChapter = null;
        for (int i = 1; i < select.size() + 1; i++) {
            Element element = select.get(i - 1);
            Element element1 = element.selectFirst("a");
            String url = element1.attr("href");
            String title = element1.text();
            if (title.length() > 80) {
                title = title.substring(0, 79);
            }
            bookChapter = new BookChapter();
            bookChapter.setTableName(table_name);
            bookChapter.setOrder(i);
            bookChapter.setTitle(title);
            bookChapter.setUrl(url);
            bookChapter.setSource(bookCatalog.getUrl());
            bookChapter.setContent(getChapterContenmt(url));
            bookChapterDao.insertOrUpdate(bookChapter);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                logger.error("睡眠失败" + e.fillInStackTrace());
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            logger.error("睡眠失败" + e.fillInStackTrace());
        }
    }

    /**
     * 网络获取章节内容
     */
    public String getChapterContenmt(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            logger.error("获取章节内容失败" + e.fillInStackTrace());
            return "";
        }
        Element element = doc.selectFirst("#contents");
        return element.text();
    }

    public List<BookChapter> queryBookChapters(int bookId) {
        return bookChapterDao.queryBookChapters(bookId);
    }

    public BookChapter queryBookChapter(int bookId, int order) {
        return bookChapterDao.queryBookChapter(bookId, order);
    }

    public BookCatalog queryBookCatalog(int bookId) {
        return bookCatalogDao.queryBookCatalog(bookId);
    }

    public void updateBookChapterContent(BookChapter bookChapter) {
        bookChapterDao.insertOrUpdate(bookChapter);
    }

    /**
     * 我的书架
     *
     * @param openId
     * @return
     */
    public List<BookCatalog> queryMyBookByOpenId(String openId) {
        return myBookDao.queryMyBookByOpenId(openId);
    }

    /**
     * 加入书架
     *
     * @param myBook
     */
    public void addBook(MyBook myBook) {
        myBookDao.addBook(myBook);
    }

    /**
     * 重书架移除书籍
     *
     * @param openId
     * @param bookId
     */
    public void removeBook(String openId, int bookId) {
        myBookDao.removeBook(openId, bookId);
    }
}
