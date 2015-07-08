package grails3.geb.example
import geb.spock.GebSpec
import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import grails3.geb.example.pages.BookCreatePage
import grails3.geb.example.pages.BookListPage
import grails3.geb.example.pages.BookShowPage
import spock.lang.Ignore
import spock.lang.Stepwise

// I wrote this test to check and see if the @Rollback annotation rolled back data changes in functional tests
// and found that it did not, but I figured I'd leave the test in and ignore it.
@Ignore
@Integration
@Rollback
@Stepwise // Force the test cases to run in the order they appear in the class
class RollbackGebSpec extends GebSpec {

    def 'create some Books'() {
        given:
        BookCreatePage bookCreatePage = to BookCreatePage

        when:
        BookShowPage bookShowPage = bookCreatePage.createBook('Should be rolled back')

        then:
        assert bookShowPage.bookTitle == 'Should be rolled back'
    }

    def 'Book list page should have no books on it'() {
        when:
        BookListPage bookListPage = to BookListPage

        then:
        assert bookListPage.numberOfBooks == 0
    }
}
