package grails3.geb.example

import geb.spock.GebReportingSpec
import grails.test.mixin.integration.Integration
import grails3.geb.example.pages.BookCreatePage
import grails3.geb.example.pages.BookShowPage
import grails3.geb.example.test.QueryExecutor
import org.springframework.beans.factory.annotation.Autowired

@Integration
class BookTwoGebSpec extends GebReportingSpec  {
    @Autowired
    QueryExecutor queryExecutor

    def "should create another Book"() {
        given:
        BookCreatePage bookCreatePage = to BookCreatePage

        when:
        BookShowPage bookShowPage = bookCreatePage.createBook('My Second Book')

        then:
        assert bookShowPage.bookTitle == 'My Second Book'

        and:
        def findBookQuery = Book.where { title == 'My Second Book'}
        assert queryExecutor.find(findBookQuery)?.title == 'My Second Book'
    }
}
