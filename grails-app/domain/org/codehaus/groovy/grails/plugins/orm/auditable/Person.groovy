package org.codehaus.groovy.grails.plugins.orm.auditable

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@TableChangeAudit(clazz = PersonAudit)
@EqualsAndHashCode
@ToString(includeFields = true)
class Person implements Serializable {

    /** Serialization Version ID compatibility - indication of what version may be restored.*/
    private static final long serialVersionUID = 1L

    String name
    Date birthDate

    static mapping = {
        autoTimestamp true
        version true
    }
}
