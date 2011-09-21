package edu.internet2.middleware.shibboleth.idp.postlogin;

/**
 * Indicates that principal is not found in the local data store
 */
public class NoSuchPrincipalException extends RuntimeException {

    public NoSuchPrincipalException(String s) {
        super(s);
    }
}
