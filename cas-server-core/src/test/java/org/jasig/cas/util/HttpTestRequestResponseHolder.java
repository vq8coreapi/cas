package org.jasig.cas.util;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.webflow.context.servlet.ServletExternalContext;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockRequestContext;

public class HttpTestRequestResponseHolder {

    public static void mock() {
        MockServletContext servletContext = new MockServletContext();
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setServerName("localhost");
        MockRequestContext requestContext = new MockRequestContext();
        requestContext.setExternalContext(new ServletExternalContext(servletContext, request, response));
        HttpUtils.setFlowRequestContext(requestContext);
    }

    public static void clear() {
        HttpUtils.setFlowRequestContext(null);
    }
}
