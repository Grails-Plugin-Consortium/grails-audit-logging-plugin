package org.codehaus.groovy.grails.plugins.orm.auditable

import grails.plugin.spock.IntegrationSpec

/**
 */
class DomainClassSpec extends IntegrationSpec {

    def "Saving a person and ensure it gets audited"() {
        given:
        def name = 'John'
        def birthDate = new Date()


        when:
        def person = new Person(name: name, birthDate: birthDate)

        then:
        PersonAudit.count() == 0
        Person.count() == 0

        when:
        person.save()
        def personAudit = PersonAudit.findWhere(name: name)

        then:
        Person.count() == 1
        PersonAudit.count() == 1
        personAudit.name == name
        personAudit.birthDate == birthDate
        personAudit.auditID == person.id.toString()
    }

    def "Saving a zombie with a shared audit class and ensure it gets audited"() {
        given:
        def name = 'John'
        def birthDate = new Date()
        def zombieDate = new Date() + 2

        when:
        def zombie = new Zombie(name: name, birthDate: birthDate, zombieDate: zombieDate)

        then:
        PersonAudit.count() == 0
        Zombie.count() == 0

        when:
        zombie.save()
        def personAudit = PersonAudit.findWhere(name: name)

        then:
        Zombie.count() == 1
        PersonAudit.count() == 1
        personAudit.name == name
        personAudit.birthDate == birthDate
        personAudit.auditID == zombie.id.toString()
    }


//    def "Saving a person then delete it"() {
//        given:
//        def name = 'John'
//        def birthDate = new Date()
//
//        when:
//        def person = new Person(name: name, birthDate: birthDate)
//
//        then:
//        PersonAudit.count() == 0
//        Person.count() == 0
//
//        when:
//        person.save()
//        def personAudit = PersonAudit.findAllWhere(name: name)
//
//        then:
//        Person.count() == 1
//        PersonAudit.count() == 1
//        personAudit.get(0).name == name
//        personAudit.get(0).birthDate == birthDate
//        personAudit.get(0).auditID == person.id.toString()
//
//        when:
//        def deletePerson = Person.get(person.id)
//        deletePerson.delete()
//        personAudit = PersonAudit.findAllWhere(name: name)
//
//        then:
//        Person.count() == 0
//        PersonAudit.count() == 2
//        personAudit.get(1).name == name
//        personAudit.get(1).birthDate == birthDate
//        personAudit.get(1).auditID == person.id.toString()
//    }

}
