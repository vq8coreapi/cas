package org.jasig.cas.web.util;

import org.jasig.cas.util.HttpUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CasHttpMessageFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
		HttpUtils.setCasHttpMessage(new HttpUtils.CasHttpMessage(req, resp));
		
		chain.doFilter(request, response);
	}

}
