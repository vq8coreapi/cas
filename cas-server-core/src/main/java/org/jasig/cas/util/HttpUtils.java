package org.jasig.cas.util;

import org.jasig.cas.model.CasHttpMessage;

public class HttpUtils {

	private static ThreadLocal<CasHttpMessage> casHttpMessage = new ThreadLocal<CasHttpMessage>();

	public static CasHttpMessage getCasHttpMessage() {
		return casHttpMessage.get();
	}

	public static void setCasHttpMessage(CasHttpMessage casHttpMessage) {
		HttpUtils.casHttpMessage.set(casHttpMessage);
	}
}
