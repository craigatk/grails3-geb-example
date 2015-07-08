package grails3.geb.example
import geb.spock.GebSpec
import grails.test.mixin.integration.Integration
import grails3.geb.example.pages.AuthorCreatePage
import grails3.geb.example.pages.AuthorShowPage

@Integration
class AuthorTwoGebSpec extends GebSpec {
    void "should create Author"() {
       given:
       AuthorCreatePage authorCreatePage = to AuthorCreatePage

        when:
        AuthorShowPage authorShowPage = authorCreatePage.createAuthor('Jim', 'Smith')

        then:
        assert authorShowPage.firstName == 'Jim'
        assert authorShowPage.lastName == 'Smith'
    }
}
