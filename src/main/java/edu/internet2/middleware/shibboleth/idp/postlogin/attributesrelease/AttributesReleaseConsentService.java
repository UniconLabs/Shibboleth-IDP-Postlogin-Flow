package edu.internet2.middleware.shibboleth.idp.postlogin.attributesrelease;

import edu.internet2.middleware.shibboleth.idp.postlogin.NoSuchPrincipalException;

/**
 * Domain service API defining operations pertaining to attributes release consent from users
 *
 * @author Dmitriy Kopylenko
 */
public interface AttributesReleaseConsentService {

    boolean requiresToActOnAttributesReleaseConsent(String principalName, String ferpaValue) throws NoSuchPrincipalException;


}
