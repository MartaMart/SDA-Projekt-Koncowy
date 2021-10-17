package com.patmar.projektkoncowy.student

import spock.lang.Specification
import spock.lang.Subject;

class StudentServiceSpec extends Specification {


    def repository = Mock(StudentRepository)

    @Subject
    def service = new StudentService(repository)

    def 'should call repository on save'() {
        when:
        service.addStudent(_ as StudentCreateRequest)

        then:
        1 * repository.save(_)
    }

    def 'should find all students on repository'() {
        given:
        repository.findAll() >> [new Student("Andrzej", "Kowal", "akol@gmail.com")]

        when:
        def result = service.findAll()

        then:
        result.size() == 1
        result.first().name == "Andrzej"
        result.first().surname == "Kowal"
        result.first().email == "akol@gmail.com"
    }

//    def 'should remove student from repository' () {
//        when:
//        service.deleteStudent(student)
//
//        then:
//        repository.deleteById(student)
//    }
}
