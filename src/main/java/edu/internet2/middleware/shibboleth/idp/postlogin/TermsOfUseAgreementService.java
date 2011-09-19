package edu.internet2.middleware.shibboleth.idp.postlogin;

/**
 * Domain service API defining operations pertaining to terms of use agreement
 *
 * @author Dmitriy Kopylenko
 */
public interface TermsOfUseAgreementService {

    boolean requiresToActOnAgreement(String principalName) throws NoSuchPrincipalException;

    void acceptAgreement(String principalName) throws NoSuchPrincipalException;

    void rejectAgreement(String principalName) throws NoSuchPrincipalException;
}
