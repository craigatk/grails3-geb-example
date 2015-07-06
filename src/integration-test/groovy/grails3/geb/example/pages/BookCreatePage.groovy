package grails3.geb.example.pages

class BookCreatePage extends geb.Page {
    static url = "/book/create"

    static content = {
        authorField(wait: true) { $("#author") }

        titleField(wait: true) { $("#title") }

        createButton(to: BookShowPage) { $(".save") }
    }

    BookShowPage createBook(String title) {
        authorField.value("Test Author")

        titleField.value(title)

        createButton.click()

        return browser.page
    }
}
