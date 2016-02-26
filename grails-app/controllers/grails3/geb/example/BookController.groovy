package grails3.geb.example

import grails.rest.RestfulController

class BookController extends RestfulController<Book>{

    BookController() {
        super(Book)
    }
}
