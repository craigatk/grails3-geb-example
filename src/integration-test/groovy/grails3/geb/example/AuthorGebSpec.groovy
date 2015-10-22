package grails3.geb.example

import geb.spock.GebReportingSpec
import grails.test.mixin.integration.Integration
import grails3.geb.example.pages.AuthorCreatePage
import grails3.geb.example.pages.AuthorShowPage
import grails3.geb.example.test.AuthorDataUtil
import org.springframework.beans.factory.annotation.Autowired

@Integration
class AuthorGebSpec extends GebReportingSpec {
    @Autowired
    AuthorDataUtil authorDataUtil

    void "should create Author"() {
       given:
       AuthorCreatePage authorCreatePage = to AuthorCreatePage

        when:
        AuthorShowPage authorShowPage = authorCreatePage.createAuthor('First', 'Last')

        then:
        assert authorShowPage.firstName == 'First'
        assert authorShowPage.lastName == 'Last'

        and:
        assert authorDataUtil.findByLastName('Last')?.firstName == 'First'
    }
}
