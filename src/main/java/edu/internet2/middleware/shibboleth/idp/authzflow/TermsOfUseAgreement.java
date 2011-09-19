package edu.internet2.middleware.shibboleth.idp.authzflow;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents a ToU domain concept
 *
 * @author Dmitriy Kopylenko
 */
public class TermsOfUseAgreement implements Serializable {

    private Action action = Action.NONE_TAKEN;

    private Date termsAcceptanceDate;

    public void accept

    public static enum Action {
        AGREED,
        DISAGREED,
        NONE_TAKEN
    }
}
