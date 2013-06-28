package org.codehaus.groovy.grails.plugins.orm.auditable

/**
 */
public interface AuditClass {
    String getAuditID();
    String getAuditText();
    void setAuditID(String auditID);
    void setAuditText(String AuditText);


}