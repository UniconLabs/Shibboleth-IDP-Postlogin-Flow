package edu.internet2.middleware.shibboleth.idp.postlogin;

import java.io.Serializable;

/**
 * Represents an authenticated principal against IDP
 *
 * @author Dmitriy Kopylenko
 */
public class AuthenticatedPrincipal implements Serializable {

    private String name;

    private TermsOfUseAgreement termsOfUseAgreement;

    public AuthenticatedPrincipal(String name) {
        this.name = name;
        this.termsOfUseAgreement = new TermsOfUseAgreement(this);
    }

    public String getName() {
        return name;
    }

    public TermsOfUseAgreement getTermsOfUseAgreement() {
        return termsOfUseAgreement;
    }
}
