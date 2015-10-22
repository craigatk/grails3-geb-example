package grails3.geb.example.test

import grails.gorm.DetachedCriteria
import grails.transaction.Transactional


/**
 * Fetch data in functional tests by passing in GORM 'where' queries and
 * executing them inside the running application.
 *
 * See this page for 'where' query syntax:
 * https://grails.github.io/grails-doc/latest/guide/GORM.html#whereQueries
 */
@Transactional
class QueryExecutor {
    def find(DetachedCriteria query) {
        query.find()
    }

    def list(DetachedCriteria query) {
        query.list()
    }
}
