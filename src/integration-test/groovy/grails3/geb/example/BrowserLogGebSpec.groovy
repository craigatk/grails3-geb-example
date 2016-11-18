package grails3.geb.example

import geb.spock.GebReportingSpec
import grails.test.mixin.integration.Integration
import grails3.geb.example.pages.AuthorCreatePage
import grails3.geb.example.pages.AuthorEditPage
import grails3.geb.example.test.AuthorDataUtil
import org.openqa.selenium.logging.LogEntries
import org.openqa.selenium.logging.LogEntry
import org.openqa.selenium.logging.LogType
import org.springframework.beans.factory.annotation.Autowired

import java.util.logging.Level

@Integration
class BrowserLogGebSpec extends GebReportingSpec {
    @Autowired
    AuthorDataUtil authorDataUtil

    def 'author edit page has a Javascript error on it, should capture browser log'() {
        given:
        AuthorCreatePage authorCreatePage = to AuthorCreatePage
        authorCreatePage.createAuthor('Richard', 'Castle')

        Author author = waitFor { authorDataUtil.findByLastName('Castle') }

        when:
        AuthorEditPage authorEditPage = to(AuthorEditPage, author.id)

        then:
        assert authorEditPage.title == 'Edit Author'
    }

    def cleanup() {
        try {
            LogEntries logs = driver.manage().logs().get(LogType.BROWSER)
            List<LogEntry> errorLogEntries = logs.filter(Level.SEVERE)

            if (errorLogEntries) {
                println "Browser errors:"

                errorLogEntries.each { logEntry ->
                    println("[${logEntry.level}] ${logEntry.message}")
                }
            }
        } catch (Exception e) {
            println "Error capturing browser logs"
        }
    }
}
