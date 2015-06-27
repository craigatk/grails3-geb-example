package grails3.geb.example

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Author)
class AuthorSpec extends Specification {

    def "should save new Author"() {
        given:
        String firstName = 'Richard'
        String lastName = 'Castle'

        when:
        Author author = new Author(firstName: firstName, lastName: lastName).save()

        then:
        assert author

        assert Author.findByFirstName(firstName)?.lastName == lastName
    }
}
