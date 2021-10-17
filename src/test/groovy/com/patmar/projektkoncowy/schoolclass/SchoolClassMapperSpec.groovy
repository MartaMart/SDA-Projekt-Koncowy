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
        schoolClass.getGradeLevel() == schoolClassBody.getGradeLevel()
        schoolClass.getStudents() == Collections.emptyList()
        schoolClass.getSubjects() == Collections.emptyList()
        schoolClass.getTeacher() == null
    }

    def "map schoolClass to view"() {
        given:
        def mockSchoolClass = Mock(SchoolClass)
        when:
        def view = classMapper.mapToView(mockSchoolClass)
        then:
        view.getTeacher() == mockSchoolClass.teacher
        view.getSubjects() == mockSchoolClass.subjects
        view.getStudents() == mockSchoolClass.students
        view.getGradeLevel() == mockSchoolClass.gradeLevel
    }

    def "map id and grade from SchoolClass"() {
        given:
        def mockSchoolClass = Mock(SchoolClass)
        when:
        def grade = classMapper.mapToIdAndGrade(mockSchoolClass)
        then:
        grade.getGradeLevel() == mockSchoolClass.gradeLevel
        grade.getId() == mockSchoolClass.id
    }
}