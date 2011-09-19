package edu.internet2.middleware.shibboleth.idp.postlogin;

import java.util.Date;

/**
 * Mock implementation that alwasys returns true for the expiration
 */
public class AlawaysExpired implements TermsOfUseAcceptanceExpirationStrategy {

    @Override
    public boolean isExpired(Date termsOfUseAcceptanceDate) throws IllegalArgumentException {
        return true;
    }
}
