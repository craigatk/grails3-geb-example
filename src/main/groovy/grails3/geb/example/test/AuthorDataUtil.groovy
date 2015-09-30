package grails3.geb.example.test

import grails.transaction.Transactional
import grails3.geb.example.Author

@Transactional
class AuthorDataUtil {
    Author findByLastName(String lastName) {
        Author.findByLastName(lastName)
    }
}
