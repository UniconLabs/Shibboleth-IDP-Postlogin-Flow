package edu.internet2.middleware.shibboleth.idp.authzflow;

import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.definition.StateDefinition;
import org.springframework.webflow.execution.*;

import javax.servlet.ServletContext;

public class IdpIntegrationFlowListener extends FlowExecutionListenerAdapter {

    @Override
    public void sessionStarted(RequestContext context, FlowSession session) {
        ServletContext servletContext = (ServletContext) context.getExternalContext().getNativeContext();
        servletContext.getContext(session.getScope().getString("idpCallingContextName"))
                .setAttribute(session.getScope().getString("idpCallingSessionId"), "UNAUTHORIZED");
    }

    @Override
    public void sessionEnding(RequestContext context, FlowSession session, String outcome, MutableAttributeMap output) {
        ServletContext servletContext = (ServletContext) context.getExternalContext().getNativeContext();
        servletContext.getContext(session.getScope().getString("idpCallingContextName"))
                .setAttribute(session.getScope().getString("idpCallingSessionId"), "AUTHORIZED");
    }


}
