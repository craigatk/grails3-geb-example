package grails3.geb.example

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration
import grails3.geb.example.pages.BookCreatePage
import grails3.geb.example.pages.BookShowPage
import grails3.geb.example.test.BookDataUtil
import org.springframework.beans.factory.annotation.Autowired

@Integration
class BookGebSpec extends GebSpec  {
    @Autowired
    BookDataUtil bookDataUtil

    def "should create Book"() {
        given:
        BookCreatePage bookCreatePage = to BookCreatePage

        when:
        BookShowPage bookShowPage = bookCreatePage.createBook('My Book')

        then:
        assert bookShowPage.bookTitle == 'My Book'

        and:
        assert bookDataUtil.findByTitle('My Book')
    }
}
