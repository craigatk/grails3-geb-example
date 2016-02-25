# Grails3 Geb Example
Example of using Geb browser functional tests with Grails3

## Test classes

The Geb test classes are in the ```src/integration-test/groovy``` directory.

## Executing tests

To execute the tests, run

```grails test-app -integration```

or

```gradlew integrationTest```


By default this project runs the tests in Firefox, so you'll need to have Firefox installed.

### Run tests in Chrome

To run the tests in Chrome, we need to tell Geb to use the 'chrome' environment block in GebConfig.groovy. Run

```grails -Dgeb.env=chrome test-app -integration```

or

```gradlew -Dgeb.env=chrome integrationTest```
