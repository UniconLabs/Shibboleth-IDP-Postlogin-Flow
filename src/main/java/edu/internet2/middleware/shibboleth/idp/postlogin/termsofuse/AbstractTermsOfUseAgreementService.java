package edu.internet2.middleware.shibboleth.idp.postlogin.termsofuse;

/**
 * Base abstract class defining the main implementation workflow.
 * <p/>
 * The actual storage and retrieval of the data is deferred to subclases.
 * <p/>
 * Uses template method design pattern.
 *
 * @author Dmitriy Kopylenko
 */
public abstract class AbstractTermsOfUseAgreementService implements TermsOfUseAgreementService {

    TermsOfUseAcceptanceExpirationStrategy expirationStrategy;

    protected AbstractTermsOfUseAgreementService(TermsOfUseAcceptanceExpirationStrategy expirationStrategy) {
        this.expirationStrategy = expirationStrategy;
    }

    @Override
    public boolean requiresToActOnAgreement(String principalName) throws NoSuchPrincipalException {
        AuthenticatedPrincipal user = findUser(principalName);
        return user.getTermsOfUseAgreement().actionIsNeeded(this.expirationStrategy);
    }

    @Override
    public void acceptAgreement(String principalName) throws NoSuchPrincipalException {
        AuthenticatedPrincipal user = findUser(principalName);
        user.getTermsOfUseAgreement().accept();
        saveUser(user);
    }

    @Override
    public void rejectAgreement(String principalName) throws NoSuchPrincipalException {
        AuthenticatedPrincipal user = findUser(principalName);
        user.getTermsOfUseAgreement().reject();
        saveUser(user);
    }

    protected abstract AuthenticatedPrincipal findUser(String principalName) throws NoSuchPrincipalException;

    protected abstract void saveUser(AuthenticatedPrincipal user);

}
