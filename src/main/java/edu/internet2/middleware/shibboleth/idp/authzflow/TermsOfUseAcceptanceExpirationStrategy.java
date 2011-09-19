package edu.internet2.middleware.shibboleth.idp.authzflow;

import java.util.Date;

/**
 * Defines a strategy API for determining terms of use acceptance expiration
 *
 * <p><strong>Concurrency semantics: implementations must be thread-safe</strong></p>
 * @author Dmitriy Kopylenko
 */
public interface TermsOfUseAcceptanceExpirationStrategy {

    /**
     * Determines whether a given acceptance date is expired
     * @param termsOfUseAcceptanceDate
     * @return true if a given acceptance date is expired, false otherwise
     * @throws IllegalArgumentException <code>termsOfUseAcceptanceDate</code> is null
     */
    boolean isExpired(Date termsOfUseAcceptanceDate) throws IllegalArgumentException;


}
