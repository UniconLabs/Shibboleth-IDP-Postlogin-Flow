package edu.internet2.middleware.shibboleth.idp.postlogin.common;

import java.io.Serializable;

/**
 * Represents an authenticated principal against IDP
 *
 * @author Dmitriy Kopylenko
 */
public class AuthenticatedPrincipal implements Serializable {

    private String name;

    private Acceptance acceptance;

    public AuthenticatedPrincipal(String name) {
        this(name, new Acceptance("NONE_TAKEN", 0L));
    }

    public AuthenticatedPrincipal(String name, Acceptance acceptance) {
        this.name = name;
        this.acceptance = acceptance;
    }

    public String getName() {
        return name;
    }

    public Acceptance getAcceptance() {
        return acceptance;
    }
}
