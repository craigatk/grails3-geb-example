package grails3.geb.example.pages

class AuthorCreatePage extends geb.Page {
    static url = "/author/create"

    static content = {
        firstNameField(wait: true) { $("#firstName") }
        lastNameField(wait: true) { $("#lastName") }

        createButton(to: AuthorShowPage) { $(".save") }
    }

    AuthorShowPage createAuthor(String firstName, String lastName) {
        firstNameField.value(firstName)
        lastNameField.value(lastName)

        createButton.click()

        return browser.page
    }
}
