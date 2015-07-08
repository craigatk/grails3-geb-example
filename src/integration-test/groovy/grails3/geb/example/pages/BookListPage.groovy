package grails3.geb.example.pages

class BookListPage extends geb.Page {
    static url = "/book/index"

    static content = {
        listSection(wait: true) { $("#list-book") }

        listTableBody { listSection.find('tbody') }

        listRow(required: false) { listTableBody.find('tr') }
    }

    Integer getNumberOfBooks() {
        listRow.size()
    }
}
