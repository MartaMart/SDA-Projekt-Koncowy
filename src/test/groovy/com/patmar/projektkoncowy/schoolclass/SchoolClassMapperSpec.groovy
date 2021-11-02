package com.patmar.projektkoncowy.schoolclass

import spock.lang.Specification

class SchoolClassMapperSpec extends Specification {
    def classMapper = SchoolClassMapper.MAPPER

    def "map school class body to school class"() {
        given:
        def schoolClassBody = new SchoolClassRequestBody("1")
        when:
        def schoolClass = classMapper.mapToSchoolClass(schoolClassBody)
        then:
        with(schoolClass) {
            gradeLevel == schoolClassBody.gradeLevel
            students == Collections.emptyList()
            subjects == Collections.emptyList()
            teacher == null}
    }

    def "map schoolClass to view"() {
        given:
        def mockSchoolClass = Mock(SchoolClass)
        when:
        def view = classMapper.mapToView(mockSchoolClass)
        then:
        with(view){
            teacher == mockSchoolClass.teacher
            subjects == mockSchoolClass.subjects
            students == mockSchoolClass.students
            gradeLevel == mockSchoolClass.gradeLevel
        }
    }

    def "map id and grade from SchoolClass"() {
        given:
        def mockSchoolClass = Mock(SchoolClass)
        when:
        def grade = classMapper.mapToIdAndGrade(mockSchoolClass)
        then:
        with(grade){
            gradeLevel == mockSchoolClass.gradeLevel
            id == mockSchoolClass.id
        }
    }
}