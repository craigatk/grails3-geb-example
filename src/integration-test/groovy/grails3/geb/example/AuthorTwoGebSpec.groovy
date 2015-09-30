package grails3.geb.example
import geb.spock.GebSpec
import grails.test.mixin.integration.Integration
import grails3.geb.example.pages.AuthorCreatePage
import grails3.geb.example.pages.AuthorShowPage
import grails3.geb.example.test.QueryExecutor
import org.springframework.beans.factory.annotation.Autowired

@Integration
class AuthorTwoGebSpec extends GebSpec {
    @Autowired
    QueryExecutor queryExecutor

    void "should create Author"() {
       given:
       AuthorCreatePage authorCreatePage = to AuthorCreatePage

        when:
        AuthorShowPage authorShowPage = authorCreatePage.createAuthor('Jim', 'Smith')

        then:
        assert authorShowPage.firstName == 'Jim'
        assert authorShowPage.lastName == 'Smith'

        and:
        def query = Author.where { lastName == 'Smith' }
        assert queryExecutor.find(query)?.firstName == 'Jim'
    }
}
