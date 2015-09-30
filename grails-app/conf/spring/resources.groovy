import grails3.geb.example.test.AuthorDataUtil
import grails3.geb.example.test.BookDataUtil
import grails3.geb.example.test.QueryExecutor

// Place your Spring DSL code here
beans = {
    environments {
        test {
            authorDataUtil(AuthorDataUtil)
            bookDataUtil(BookDataUtil)

            queryExecutor(QueryExecutor)
        }
    }
}
