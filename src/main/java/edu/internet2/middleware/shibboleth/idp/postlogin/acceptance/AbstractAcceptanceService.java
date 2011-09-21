package edu.internet2.middleware.shibboleth.idp.postlogin.acceptance;

import edu.internet2.middleware.shibboleth.idp.postlogin.NoSuchPrincipalException;

/**
 * Base abstract class defining the main implementation workflow.
 * <p/>
 * The actual storage and retrieval of the data is deferred to subclases.
 * <p/>
 * Uses template method design pattern.
 *
 * @author Dmitriy Kopylenko
 */
public abstract class AbstractAcceptanceService implements AcceptanceService {

    AcceptanceExpirationStrategy expirationStrategy;

    protected AbstractAcceptanceService(AcceptanceExpirationStrategy expirationStrategy) {
        this.expirationStrategy = expirationStrategy;
    }

    @Override
    public final boolean requiresToAct(String principalName) throws NoSuchPrincipalException {
        AuthenticatedPrincipal user = findUserAcceptance(principalName);
        return user.getAcceptance().actionIsNeeded(this.expirationStrategy);

    }

    @Override
    public final void accept(String principalName) throws NoSuchPrincipalException {
        AuthenticatedPrincipal user = findUserAcceptance(principalName);
        user.getAcceptance().accept();
        saveUserAcceptance(user);
    }

    @Override
    public final void reject(String principalName) throws NoSuchPrincipalException {
        AuthenticatedPrincipal user = findUserAcceptance(principalName);
        user.getAcceptance().reject();
        saveUserAcceptance(user);
    }

    protected abstract AuthenticatedPrincipal findUserAcceptance(String principalName) throws NoSuchPrincipalException;

    protected abstract void saveUserAcceptance(AuthenticatedPrincipal user);
}
