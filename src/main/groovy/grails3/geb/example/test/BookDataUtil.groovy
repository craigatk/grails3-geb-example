package grails3.geb.example.test

import grails.transaction.Transactional
import grails3.geb.example.Book

@Transactional
class BookDataUtil {
    Book findByTitle(String title) {
        Book.findByTitle(title)
    }
}
