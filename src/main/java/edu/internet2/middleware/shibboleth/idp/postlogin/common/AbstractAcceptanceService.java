package edu.internet2.middleware.shibboleth.idp.postlogin.common;

import edu.internet2.middleware.shibboleth.idp.postlogin.NoSuchPrincipalException;
import edu.internet2.middleware.shibboleth.idp.postlogin.common.AuthenticatedPrincipal;
import edu.internet2.middleware.shibboleth.idp.postlogin.common.AcceptanceExpirationStrategy;
import edu.internet2.middleware.shibboleth.idp.postlogin.termsofuse.TermsOfUseAgreementService;

/**
 * Base abstract class defining the main implementation workflow.
 * <p/>
 * The actual storage and retrieval of the data is deferred to subclases.
 * <p/>
 * Uses template method design pattern.
 *
 * @author Dmitriy Kopylenko
 */
public abstract class AbstractAcceptanceService implements TermsOfUseAgreementService {

    AcceptanceExpirationStrategy expirationStrategy;

    protected AbstractAcceptanceService(AcceptanceExpirationStrategy expirationStrategy) {
        this.expirationStrategy = expirationStrategy;
    }

    @Override
    public final boolean requiresToActOnAgreement(String principalName) throws NoSuchPrincipalException {
        AuthenticatedPrincipal user = findUser(principalName);
        return user.getAcceptance().actionIsNeeded(this.expirationStrategy);
    }

    @Override
    public final void acceptAgreement(String principalName) throws NoSuchPrincipalException {
        AuthenticatedPrincipal user = findUser(principalName);
        user.getAcceptance().accept();
        saveUser(user);
    }

    @Override
    public void rejectAgreement(String principalName) throws NoSuchPrincipalException {
        AuthenticatedPrincipal user = findUser(principalName);
        user.getAcceptance().reject();
        saveUser(user);
    }

    protected abstract AuthenticatedPrincipal findUser(String principalName) throws NoSuchPrincipalException;

    protected abstract void saveUser(AuthenticatedPrincipal user);

}
