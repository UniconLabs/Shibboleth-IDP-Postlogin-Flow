package edu.internet2.middleware.shibboleth.idp.postlogin;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents a ToU domain concept
 *
 * @author Dmitriy Kopylenko
 */
public class TermsOfUseAgreement implements Serializable {

    private static enum Action {
        AGREED,
        DISAGREED,
        NONE_TAKEN
    }

    private Action action = Action.NONE_TAKEN;

    private Date termsAcceptanceDate;

    private AuthenticatedPrincipal user;

    public TermsOfUseAgreement(AuthenticatedPrincipal user) {
        this.user = user;
    }

    public void accept() {
        this.action = Action.AGREED;
        this.termsAcceptanceDate = new Date();
    }

    public void reject() {
        this.action = Action.DISAGREED;
        this.termsAcceptanceDate = null;
    }

    public boolean actionIsNeeded(TermsOfUseAcceptanceExpirationStrategy expirationStrategy) {
        if(this.termsAcceptanceDate == null) {
            return true;
        }
        if(this.action != Action.AGREED) {
            return true;
        }
        return expirationStrategy.isExpired(this.termsAcceptanceDate);
    }
}
