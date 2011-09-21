package edu.internet2.middleware.shibboleth.idp.postlogin.common;

import edu.internet2.middleware.shibboleth.idp.postlogin.NoSuchPrincipalException;
import edu.internet2.middleware.shibboleth.idp.postlogin.common.AbstractAcceptanceService;
import edu.internet2.middleware.shibboleth.idp.postlogin.common.Acceptance;
import edu.internet2.middleware.shibboleth.idp.postlogin.common.AuthenticatedPrincipal;
import edu.internet2.middleware.shibboleth.idp.postlogin.common.AcceptanceExpirationStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Simple in-memory implementation. Useful for mocking and testing.
 */
public class InMemoryAcceptanceService extends AbstractAcceptanceService {

    private Map<String, AuthenticatedPrincipal> users = new ConcurrentHashMap<String, AuthenticatedPrincipal>();

    public InMemoryAcceptanceService(AcceptanceExpirationStrategy expirationStrategy) {
        super(expirationStrategy);
        //Just hardcode. Use the other ctor to parametarize the users Map via applicationContext
        AuthenticatedPrincipal user = new AuthenticatedPrincipal("ip-user", new Acceptance("NONE_TAKEN", 0L));
        users.put("ip-user", user);
    }

    /**
     * Used for mocking and testing
     * @param expirationStrategy
     * @param users
     */
    public InMemoryAcceptanceService(AcceptanceExpirationStrategy expirationStrategy, Map<String, AuthenticatedPrincipal> users) {
        super(expirationStrategy);
        this.users = users;
    }

    @Override
    protected AuthenticatedPrincipal findTermsOfUseAgreementAcceptance(String name) {
        AuthenticatedPrincipal user = this.users.get(name);
        if(user == null) {
            throw new NoSuchPrincipalException("The principal [" + name + "] is not found.");
        }
        return user;
    }

    @Override
    protected void saveTermsOfUseAgreementAcceptance(AuthenticatedPrincipal user) {
        this.users.put(user.getName(), user);
    }
}
