package grails3.geb.example

import grails.rest.RestfulController

class AuthorController extends RestfulController<Author> {

    AuthorController() {
        super(Author)
    }
}
