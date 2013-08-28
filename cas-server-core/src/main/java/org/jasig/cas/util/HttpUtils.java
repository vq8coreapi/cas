package org.jasig.cas.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpUtils {

    private static ThreadLocal<CasHttpMessage> casHttpMessage = new ThreadLocal<CasHttpMessage>();

    public static ThreadLocal<CasHttpMessage> getCasHttpMessage() {
        return casHttpMessage;
    }

    public static void setCasHttpMessage(CasHttpMessage message) {
        casHttpMessage.set(message);
    }

    public static HttpServletRequest getRequest() {
        if (casHttpMessage.get() == null) {
            throw new IllegalStateException("CasHttpMessage is not set for this thread");
        }
        return casHttpMessage.get().getRequest();
    }

    public static Map<String, Object> getContext() {
        if (casHttpMessage.get() == null) {
            throw new IllegalStateException("CasHttpMessage is not set for this thread");
        }
        return casHttpMessage.get().getContext();
    }

    public static class CasHttpMessage {
        private final HttpServletRequest request;
        private final HttpServletResponse response;
        private final Map<String, Object> context;

        public CasHttpMessage(HttpServletRequest request, HttpServletResponse response) {
            this(request, response, new LinkedHashMap<String, Object>());
        }

        public CasHttpMessage(HttpServletRequest request, HttpServletResponse response, Map<String, Object> context) {
            this.request = request;
            this.response = response;
            this.context = context;
        }

        public HttpServletRequest getRequest() {
            return request;
        }

        public HttpServletResponse getResponse() {
            return response;
        }

        public Map<String, Object> getContext() {
            return context;
        }
    }
}
