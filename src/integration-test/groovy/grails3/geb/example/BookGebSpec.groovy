package grails3.geb.example

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import grails3.geb.example.pages.BookCreatePage
import grails3.geb.example.pages.BookShowPage

@Integration
@Rollback
class BookGebSpec extends GebSpec  {
    def "should create Book"() {
        given:
        BookCreatePage bookCreatePage = to BookCreatePage

        when:
        BookShowPage bookShowPage = bookCreatePage.createBook('My Book')

        then:
        assert bookShowPage.bookTitle == 'My Book'
    }
}
