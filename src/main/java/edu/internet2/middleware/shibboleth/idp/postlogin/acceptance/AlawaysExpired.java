package edu.internet2.middleware.shibboleth.idp.postlogin.acceptance;

import java.util.Date;

/**
 * Mock implementation that alwasys returns true for the expiration
 */
public class AlawaysExpired implements AcceptanceExpirationStrategy {

    @Override
    public boolean isExpired(Date acceptanceDate) throws IllegalArgumentException {
        return true;
    }
}
