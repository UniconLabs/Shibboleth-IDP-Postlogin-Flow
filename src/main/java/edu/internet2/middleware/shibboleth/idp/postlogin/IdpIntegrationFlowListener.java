package edu.internet2.middleware.shibboleth.idp.postlogin;

import org.springframework.webflow.definition.StateDefinition;
import org.springframework.webflow.execution.*;

import javax.servlet.ServletContext;
import java.util.Map;

/**
 * This listener plays a role of an 'IDP communication glue' and implements appropriate callbacks in the flow execution
 * lifecycle to communicate its processing status back to IDP via IDP's own ServletContext attributes.
 * @author Dmitriy Kopylenko
 */
public class IdpIntegrationFlowListener extends FlowExecutionListenerAdapter {

    @Override
    public void stateEntering(RequestContext context, StateDefinition state) throws EnterStateVetoException {
        //Mark the status of this flow and communicate it with IDP via its ServletContext attribute keyed
        //by priviously passed IDP's HttpSession ID, so IDP (integretion filter) could make a decision what to do next.
        String status = null;
        if ("continue".equals(state.getId())) {
            status = "POST_LOGIN_FLOW_CONTINUE";
        } else if ("unauthorized".equals(state.getId()) || "rejected".equals(state.getId())) {
            status = "POST_LOGIN_FLOW_STOP";
        }
        if (status == null) {
            return;
        }
        CallingContextNameAndSessionId nameAndSessionId = extractFrom(context);
        ServletContext servletContext = (ServletContext) context.getExternalContext().getNativeContext();
        ServletContext callingContext = servletContext.getContext(nameAndSessionId.name);

        //Synchronize on the calling ServletContext monitor here, so the calling context could synchronize on the same monitor
        // and see this update: rules of Java Threads visibility
        synchronized (callingContext) {
            callingContext.setAttribute(nameAndSessionId.sessionId, status);
        }
    }

    @Override
    public void stateEntered(RequestContext context, StateDefinition previousState, StateDefinition newState) {
        //This is our start state. Mark the status as 'in progress', so the IDP (integration filter) could check
        // and stop processing if malicios or accidental attempt is made to redirect to IDP in the middle of this flow.
        if ("checkRelyingParty".equals(newState.getId()) || "debug".equals(newState.getId())) {
            CallingContextNameAndSessionId nameAndSessionId = extractFrom(context);
            ServletContext servletContext = (ServletContext) context.getExternalContext().getNativeContext();
            ServletContext callingContext = servletContext.getContext(nameAndSessionId.name);
            if (callingContext == null) {
                throw new FlowExecutionException(context.getActiveFlow().getId(), context.getCurrentState().getId(),
                        "Invalid entry into this flow. Probably used back button on the browser when flow has already ended.");
            }
            //Synchronize on the calling ServletContext monitor here, so the calling context could synchronize on the same monitor
            // and see this update: rules of Java Threads visibility
            synchronized (callingContext) {
                callingContext.setAttribute(nameAndSessionId.sessionId, "POST_LOGIN_FLOW_IN_PROGRESS");
            }
        }
    }

    private CallingContextNameAndSessionId extractFrom(RequestContext ctx) {
        //Java needs native Tuples :-)
        String name = (String) ((Map) ctx.getFlowScope().get("idpData", Map.class)).get("callingContextName");
        String sessionId = (String) ((Map) ctx.getFlowScope().get("idpData", Map.class)).get("callingSessionId");
        return new CallingContextNameAndSessionId(name, sessionId);
    }

    private static final class CallingContextNameAndSessionId {
        String name;
        String sessionId;

        private CallingContextNameAndSessionId(String name, String sessionId) {
            this.name = name;
            this.sessionId = sessionId;
        }
    }
}
