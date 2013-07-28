package org.jasig.cas.util;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class HttpTestRequestResponseHolder {

    public static void mock() {
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setServerName("localhost");
        HttpUtils.setCasHttpMessage(new HttpUtils.CasHttpMessage(request, response));
    }

    public static void clear() {
        HttpUtils.setCasHttpMessage(null);
    }
}
