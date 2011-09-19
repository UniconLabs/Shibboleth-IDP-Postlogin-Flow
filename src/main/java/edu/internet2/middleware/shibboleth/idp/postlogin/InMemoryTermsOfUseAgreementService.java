package edu.internet2.middleware.shibboleth.idp.postlogin;

import com.sun.tools.corba.se.idl.Noop;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Simple in-memory implementation useful for testing
 */
public class InMemoryTermsOfUseAgreementService  implements TermsOfUseAgreementService {


    private Map<String, AuthenticatedPrincipal> users = new ConcurrentHashMap<String, AuthenticatedPrincipal>();

    private TermsOfUseAcceptanceExpirationStrategy expirationStrategy;

    public InMemoryTermsOfUseAgreementService(TermsOfUseAcceptanceExpirationStrategy expirationStrategy) {
        this.expirationStrategy = expirationStrategy;
        //Just hardcode for now. Later could externalize to the applicationContext config.
        //Doesn't make a difference at the moment
        AuthenticatedPrincipal user = new AuthenticatedPrincipal("ip-user");
        users.put("ip-user", user);

    }

    @Override
    public boolean requiresToActOnAgreement(String principalName) throws NoSuchPrincipalException {
        AuthenticatedPrincipal user = getUser(principalName);
        return user.getTermsOfUseAgreement().actionIsNeeded(this.expirationStrategy);
    }

    @Override
    public void acceptAgreement(String principalName) throws NoSuchPrincipalException {
        AuthenticatedPrincipal user = getUser(principalName);
        user.getTermsOfUseAgreement().accept();
        this.users.put(principalName, user);
    }

    @Override
    public void rejectAgreement(String principalName) throws NoSuchPrincipalException {
        AuthenticatedPrincipal user = getUser(principalName);
        user.getTermsOfUseAgreement().reject();
        this.users.put(principalName, user);
    }

    private AuthenticatedPrincipal getUser(String name) {
        AuthenticatedPrincipal user = this.users.get(name);
        if(user == null) {
            throw new NoSuchPrincipalException("The principal [" + name + "] is not found.");
        }
        return user;
    }
}
