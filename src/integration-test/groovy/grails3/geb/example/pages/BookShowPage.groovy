package grails3.geb.example.pages

class BookShowPage extends geb.Page {
    static content = {
        propertyList(wait: true) { $(".property-list") }
        bookTitleValue { propertyList.find('aria-labelledby': 'title-label') }
    }

    String getBookTitle() {
        return bookTitleValue.text()
    }
}
