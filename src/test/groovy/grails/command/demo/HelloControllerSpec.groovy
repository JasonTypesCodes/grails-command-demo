package grails.command.demo

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class HelloControllerSpec extends Specification implements ControllerUnitTest<HelloController> {

    void "with params and errors"() {
        given:
        params.someValue = 99

        when:
        def result = controller.doSomething()

        then:
        result
    }

    void "with params and no errors"() {
        given:
        params.someValue = 100

        when:
        def result = controller.doSomething()

        then:
        !result
    }

    void "with invalid command and no validate called"() {
        given:
        HelloCommand input = new HelloCommand(someValue: 99)

        when:
        def result = controller.doSomething(input)

        then:
        !result

    }

    void "with invalid command and validate called"() {
        given:
        HelloCommand input = new HelloCommand(someValue: 99)

        when:
        input.validate()
        def result = controller.doSomething(input)

        then:
        result
    }
}
