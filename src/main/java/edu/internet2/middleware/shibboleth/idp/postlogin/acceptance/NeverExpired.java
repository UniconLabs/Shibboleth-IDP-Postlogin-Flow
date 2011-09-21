package edu.internet2.middleware.shibboleth.idp.postlogin.acceptance;

import java.util.Date;

/**
 * Mock implementation that alwasys returns false for the expiration
 */
public class NeverExpired implements AcceptanceExpirationStrategy {

    @Override
    public boolean isExpired(Date acceptanceDate) throws IllegalArgumentException {
        return false;
    }
}
