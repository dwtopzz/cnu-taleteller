package com.cnu.taleteller.backend.domain.book.controller;

import com.cnu.taleteller.backend.domain.book.domain.Book;
import com.cnu.taleteller.backend.domain.book.dto.BookDto;
import com.cnu.taleteller.backend.domain.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/search")
    public ResponseEntity<List<Book>> search(@RequestParam String searchType, @RequestParam String keyword) {

        List<Book> searchResults;

        switch (searchType) {
/*            case "name":
                searchResults = bookService.searchByName(keyword);
                break;*/
            case "title":
                searchResults = bookService.searchByTitle(keyword);
                break;
            case "content":
                searchResults = bookService.searchByContent(keyword);
                break;
            default:
                return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(searchResults);
    }

    @GetMapping("/detail/{bookId}")
    public ResponseEntity<Book> getBookDetail(@PathVariable Long bookId) {
        Book book = bookService.getBookByBookId(bookId);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/detail/{bookId}/recommend")
    public ResponseEntity<Book> recommendBook(@PathVariable Long bookId) {
        Book book = bookService.recommendBook(bookId);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

}