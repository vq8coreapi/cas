package org.jasig.cas.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.model.CasHttpMessage;
import org.jasig.cas.util.HttpUtils;

public class CasHttpMessageFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		CasHttpMessage casHttpMessage = new CasHttpMessage();
		casHttpMessage.setRequest((HttpServletRequest) request);
		casHttpMessage.setResponse((HttpServletResponse) response);
		HttpUtils.setCasHttpMessage(casHttpMessage);
		
		chain.doFilter(request, response);
	}

}
