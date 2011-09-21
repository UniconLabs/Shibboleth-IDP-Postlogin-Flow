package edu.internet2.middleware.shibboleth.idp.postlogin.termsofuse;

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


    public TermsOfUseAgreement(String actionTaken, long timestamp) {
        this.action = Action.valueOf(actionTaken);
        if (timestamp > 0L) {
            this.termsAcceptanceDate = new Date(timestamp);
        }
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

    /* package scoped */
    String getActionAsString() {
        return this.action.toString();
    }

    long getAcceptanceTimestamp() {
        return this.termsAcceptanceDate.getTime();
    }
}
