package edu.internet2.middleware.shibboleth.idp.postlogin.acceptance;

import edu.internet2.middleware.shibboleth.idp.postlogin.NoSuchPrincipalException;

/**
 * An API defining operations pertaining to user's acceptance e.g.
 * terms of use acceptance, attributes release consent acceptance, etc.
 *
 * <p><strong>Concurrency semantics: implementations must be thread-safe</strong></p>
 * @author Dmitriy Kopylenko
 */
public interface AcceptanceService {

    boolean requiresToAct(String principalName) throws NoSuchPrincipalException;

    void accept(String principalName) throws NoSuchPrincipalException;

    void reject(String principalName) throws NoSuchPrincipalException;
}
