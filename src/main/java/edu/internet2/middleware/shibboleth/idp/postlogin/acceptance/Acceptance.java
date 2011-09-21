package edu.internet2.middleware.shibboleth.idp.postlogin.acceptance;

import java.io.Serializable;
import java.util.Date;

/**
 * Value class representing user's acceptance for terms of use, attributes release consent, etc.
 *
 * @author Dmitriy Kopylenko
 */
public class Acceptance implements Serializable {

    private static enum Action {
        AGREED,
        DISAGREED,
        NONE_TAKEN
    }

    private Action action = Action.NONE_TAKEN;

    private Date acceptanceDate;


    public Acceptance(String actionTaken, long timestamp) {
        this.action = Action.valueOf(actionTaken);
        if (timestamp > 0L) {
            this.acceptanceDate = new Date(timestamp);
        }
    }

    public void accept() {
        this.action = Action.AGREED;
        this.acceptanceDate = new Date();
    }

    public void reject() {
        this.action = Action.DISAGREED;
        this.acceptanceDate = null;
    }

    public boolean actionIsNeeded(AcceptanceExpirationStrategy expirationStrategy) {
        if (this.acceptanceDate == null) {
            return true;
        }
        if (this.action != Action.AGREED) {
            return true;
        }
        return expirationStrategy.isExpired(this.acceptanceDate);
    }

    public String getActionAsString() {
        return this.action.toString();
    }

    public long getAcceptanceTimestamp() {
        return this.acceptanceDate == null ? 0L : this.acceptanceDate.getTime();
    }
}
