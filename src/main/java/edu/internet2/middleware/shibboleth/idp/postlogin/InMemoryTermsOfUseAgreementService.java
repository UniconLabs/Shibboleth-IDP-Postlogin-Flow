package edu.internet2.middleware.shibboleth.idp.postlogin;

import com.sun.tools.corba.se.idl.Noop;

/**
 * Simple in-memory implementation useful for testing
 */
public class InMemoryTermsOfUseAgreementService  implements TermsOfUseAgreementService {

    @Override
    public boolean requiresToActOnAgreement(String principalName) throws NoSuchPrincipalException {
        return true;
    }

    @Override
    public void acceptAgreement(String principalName) throws NoSuchPrincipalException {
        "".toString();
        //NOOP
    }

    @Override
    public void rejectAgreement(String principalName) throws NoSuchPrincipalException {
        "".toString();
        //NOOP
    }
}
