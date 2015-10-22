package grails3.geb.example

import geb.spock.GebReportingSpec
import grails.test.mixin.integration.Integration
import grails3.geb.example.pages.AuthorCreatePage
import grails3.geb.example.pages.AuthorShowPage
import grails3.geb.example.test.QueryExecutor
import org.springframework.beans.factory.annotation.Autowired

@Integration
class AuthorTwoGebSpec extends GebReportingSpec {
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

        and: 'example of using queryExecutor.find()'
        def findAuthorQuery = Author.where { lastName == 'Smith' }
        assert queryExecutor.find(findAuthorQuery)?.firstName == 'Jim'

        and: 'example of using queryExecutor.list()'
        def listAuthorsQuery = Author.where { lastName == 'Smith' }
        List<Author> authors = queryExecutor.list(listAuthorsQuery)
        assert authors?.size() == 1
        assert authors[0].firstName == 'Jim'
    }
}
