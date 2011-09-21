package edu.internet2.middleware.shibboleth.idp.postlogin.termsofuse;

import edu.internet2.middleware.shibboleth.idp.postlogin.NoSuchPrincipalException;

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
