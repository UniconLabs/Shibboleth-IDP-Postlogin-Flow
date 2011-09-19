package edu.internet2.middleware.shibboleth.idp.postlogin;

import java.util.Date;

/**
 * Mock implementation that alwasys returns false for the expiration
 */
public class NeverExpired implements TermsOfUseAcceptanceExpirationStrategy {

    @Override
    public boolean isExpired(Date termsOfUseAcceptanceDate) throws IllegalArgumentException {
        return false;
    }
}
