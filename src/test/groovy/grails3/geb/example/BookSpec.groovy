package grails3.geb.example

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Book)
@Mock(Author)
class BookSpec extends Specification {
    def "should create new Book"() {
        given:
        Author author = new Author(firstName: 'Richard', lastName: 'Castle').save()

        String title = "Storm's Last Stand"

        when:
        Book book = new Book(author: author, title: title).save(failOnError: true)

        then:
        assert Book.findByTitle(title)?.author?.firstName == 'Richard'
    }
}
