import grails.util.Environment
import grails3.geb.example.Author

class BootStrap {

    def init = { servletContext ->
        if (Environment.current == Environment.TEST) {
            new Author(firstName: 'Test', lastName: 'Author').save(failOnError: true)
        }
    }
    def destroy = {
    }
}
