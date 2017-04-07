/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package httpclient;

import javax.net.ssl.X509TrustManager;

/**
 * 解决在开发https应用时，抛出如下的异常会：”javax.net.ssl.SSLPeerUnverifiedException: peer not authenticated”。问题
 * @Filename TrustManager.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author liujunwei
 *
 * @Email ljunwei@yiji.com
 *       
 * @History
 *<li>Author: liujunwei</li>
 *<li>Date: 2013-1-9</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class TrustManager implements X509TrustManager {
	/* (non-Javadoc)
	 * @see javax.net.ssl.X509TrustManager#checkClientTrusted(java.security.cert.X509Certificate[], java.lang.String)
	 */
	@Override
	public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
																								throws java.security.cert.CertificateException {
		
	}
	
	/* (non-Javadoc)
	 * @see javax.net.ssl.X509TrustManager#checkServerTrusted(java.security.cert.X509Certificate[], java.lang.String)
	 */
	@Override
	public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
																								throws java.security.cert.CertificateException {
	}
	
	/* (non-Javadoc)
	 * @see javax.net.ssl.X509TrustManager#getAcceptedIssuers()
	 */
	@Override
	public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}
