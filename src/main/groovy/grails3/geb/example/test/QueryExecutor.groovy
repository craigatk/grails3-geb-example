package grails3.geb.example.test

import grails.transaction.Transactional

@Transactional
class QueryExecutor {
    def find(def query) {
        query.find()
    }
}
