package org.jasig.cas.util;

import org.jasig.cas.model.CasHttpMessage;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class HttpTestRequestResponseHolder {

    public static void mock() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setServerName("localhost");

        MockHttpServletResponse response = new MockHttpServletResponse();
        HttpUtils.setCasHttpMessage(new CasHttpMessage(request, response));
    }

    public static void clear() {
        HttpUtils.setCasHttpMessage(null);
    }
}
