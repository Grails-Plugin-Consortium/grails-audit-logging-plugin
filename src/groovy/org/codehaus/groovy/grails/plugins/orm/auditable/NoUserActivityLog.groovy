package org.codehaus.groovy.grails.plugins.orm.auditable

import java.lang.annotation.Documented
import java.lang.annotation.Retention

/**
 */
import java.lang.annotation.RetentionPolicy

/**
 * A marker for methods that do not need UserActivity logged
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoUserActivityLog {

}
