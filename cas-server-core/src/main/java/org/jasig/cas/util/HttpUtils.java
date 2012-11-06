package org.jasig.cas.util;

import org.jasig.cas.model.CasHttpMessage;

public class HttpUtils {

	private static ThreadLocal<CasHttpMessage> casHttpMessage = new ThreadLocal<CasHttpMessage>();

	public static ThreadLocal<CasHttpMessage> getCasHttpMessage() {
		return casHttpMessage;
	}

	public static void setCasHttpMessage(ThreadLocal<CasHttpMessage> casHttpMessage) {
		HttpUtils.casHttpMessage = casHttpMessage;
	}
}
