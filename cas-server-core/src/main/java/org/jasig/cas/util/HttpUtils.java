package org.jasig.cas.util;

import org.jasig.cas.web.support.WebUtils;
import org.springframework.webflow.execution.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtils {

    private static ThreadLocal<RequestContext> casFlowRequestContext = new ThreadLocal<RequestContext>();

    public static RequestContext getFlowRequestContext() {
        return casFlowRequestContext.get();
    }

    public static void setFlowRequestContext(RequestContext requestContext) {
        casFlowRequestContext.set(requestContext);
    }

    public static HttpServletRequest getRequest() {
        return WebUtils.getHttpServletRequest(getFlowRequestContext());
    }

    public static HttpServletResponse getResponse() {
        return WebUtils.getHttpServletResponse(getFlowRequestContext());
    }
}
