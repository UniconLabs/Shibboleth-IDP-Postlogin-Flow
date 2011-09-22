package edu.internet2.middleware.shibboleth.idp.postlogin.acceptance;

import edu.internet2.middleware.shibboleth.idp.postlogin.NoSuchPrincipalException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory implemntation useful for prototyping, demos and lightweight unit testing.
 *
 * @author Dmitriy Kopylenko
 */
public class InMemoryAcceptanceStore extends AbstractAcceptanceService {

    private Map<String, AuthenticatedPrincipal> users = new ConcurrentHashMap<String, AuthenticatedPrincipal>(1);

    public InMemoryAcceptanceStore(AcceptanceExpirationStrategy expirationStrategy) {
        super(expirationStrategy);
        //Just hardcode one here. No problem for demos.
        Acceptance acceptance = new Acceptance("NONE_TAKEN", 0L);
        AuthenticatedPrincipal user = new AuthenticatedPrincipal("ip-user", acceptance);
        this.users.put("ip-user", user);
    }

    @Override
    protected AuthenticatedPrincipal findUserAcceptance(String principalName) throws NoSuchPrincipalException {
        return this.users.get(principalName);
    }

    @Override
    protected void saveUserAcceptance(AuthenticatedPrincipal user) {
        this.users.put(user.getName(), user);
    }
}
