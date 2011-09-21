package edu.internet2.middleware.shibboleth.idp.postlogin.termsofuse;

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
        this(name, new TermsOfUseAgreement("NONE_TAKEN", 0L));
    }

    public AuthenticatedPrincipal(String name, TermsOfUseAgreement termsOfUseAgreement) {
        this.name = name;
        this.termsOfUseAgreement = termsOfUseAgreement;
    }

    public String getName() {
        return name;
    }

    public TermsOfUseAgreement getTermsOfUseAgreement() {
        return termsOfUseAgreement;
    }
}
