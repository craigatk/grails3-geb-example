package grails3.geb.example.pages

import geb.Page

class AuthorShowPage extends Page {
    static url = "author/show"

    static content = {
        propertyList(wait: true) { $(".property-list") }
        firstNameValue { propertyList.find('aria-labelledby': 'firstName-label') }
        lastNameValue { propertyList.find('aria-labelledby': 'lastName-label') }
    }

    String getFirstName() {
        firstNameValue.text()
    }

    String getLastName() {
        lastNameValue.text()
    }
}
