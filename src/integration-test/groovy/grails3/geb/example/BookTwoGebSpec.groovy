package grails3.geb.example
import geb.spock.GebSpec
import grails.test.mixin.integration.Integration
import grails3.geb.example.pages.BookCreatePage
import grails3.geb.example.pages.BookShowPage

@Integration
class BookTwoGebSpec extends GebSpec  {

    def "should create another Book"() {
        given:
        BookCreatePage bookCreatePage = to BookCreatePage

        when:
        BookShowPage bookShowPage = bookCreatePage.createBook('My Second Book')

        then:
        assert bookShowPage.bookTitle == 'My Second Book'
    }
}
