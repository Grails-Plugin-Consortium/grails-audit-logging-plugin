package org.codehaus.groovy.grails.plugins.orm.auditable

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString(includeFields=true)
class PersonAudit implements Serializable {

    String name
    Date birthDate

    static mapping = {
        autoTimestamp true
        version true
    }
}
