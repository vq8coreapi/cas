package org.jasig.cas.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

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

    public static Properties getProperties() {
        if (casHttpMessage.get() == null) {
            throw new IllegalStateException("CasHttpMessage is not set for this thread");
        }
        return casHttpMessage.get().getProperties();
    }

    public static class CasHttpMessage {
        private final HttpServletRequest request;
        private final HttpServletResponse response;
        private final Properties properties;

        public CasHttpMessage(HttpServletRequest request, HttpServletResponse response) {
            this(request, response, new Properties());
        }

        public CasHttpMessage(HttpServletRequest request, HttpServletResponse response, Properties properties) {
            this.request = request;
            this.response = response;
            this.properties = properties;
        }

        public HttpServletRequest getRequest() {
            return request;
        }

        public HttpServletResponse getResponse() {
            return response;
        }

        public Properties getProperties() {
            return properties;
        }
    }
}
