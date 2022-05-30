package grails.command.demo

class HelloController {

    def index() { }

    def doSomething(HelloCommand helloCommand) {
        return helloCommand.hasErrors()
    }
}

class HelloCommand {
    int someValue

    static constraints = {
        someValue min: 100
    }
}
