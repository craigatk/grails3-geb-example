package grails3.geb.example
import geb.spock.GebSpec
import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import grails3.geb.example.pages.AuthorCreatePage
import grails3.geb.example.pages.AuthorShowPage

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration
@Rollback
class AuthorGebSpec extends GebSpec {
    void "should create Author"() {
       given:
       AuthorCreatePage authorCreatePage = to AuthorCreatePage

        when:
        AuthorShowPage authorShowPage = authorCreatePage.createAuthor('First', 'Last')

        then:
        assert authorShowPage.firstName == 'First'
        assert authorShowPage.lastName == 'Last'
    }
}
