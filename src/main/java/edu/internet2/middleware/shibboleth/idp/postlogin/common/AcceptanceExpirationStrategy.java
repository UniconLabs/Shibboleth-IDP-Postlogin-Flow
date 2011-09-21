package edu.internet2.middleware.shibboleth.idp.postlogin.common;

import java.util.Date;

/**
 * Defines a strategy API for determining user's acceptance expiration, for example
 * terms of use acceptance, attributes release consent acceptance, etc.
 *
 * <p><strong>Concurrency semantics: implementations must be thread-safe</strong></p>
 * @author Dmitriy Kopylenko
 */
public interface AcceptanceExpirationStrategy {

    /**
     * Determines whether a given acceptance date is expired
     * @param acceptanceDate
     * @return true if a given acceptance date is expired, false otherwise
     * @throws IllegalArgumentException <code>acceptanceDate</code> is null
     */
    boolean isExpired(Date acceptanceDate) throws IllegalArgumentException;


}
