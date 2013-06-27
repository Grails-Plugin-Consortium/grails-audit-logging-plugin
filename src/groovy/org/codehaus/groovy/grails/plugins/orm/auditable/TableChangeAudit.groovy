package org.codehaus.groovy.grails.plugins.orm.auditable

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TableChangeAudit {
    String[] ignore() default [];
    Class clazz();
}