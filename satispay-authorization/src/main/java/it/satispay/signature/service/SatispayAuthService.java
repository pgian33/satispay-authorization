package it.satispay.signature.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import it.satispay.signature.client.CustomErrorDecoder;
import it.satispay.signature.client.FactoryRestClient;
import it.satispay.signature.client.authclient.AuthServiceClient;

@Component
public class SatispayAuthService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SatispayAuthService.class);
	
	@Value("${path.SatispayAuthenticationServiceClientPath}")
	private String satispayAuthenticationServiceClientPath;
	
	@Value("${client.connectTimeout}")
	private Long connectTimeout;
	
	@Value("${client.connectTimeoutUnit}")
	private String connectTimeoutUnit;
	
	@Value("${client.readTimeout}")
	private Long readTimeout;
	
	@Value("${client.connectTimeout}")
	private String readTimeoutUnit;
	
	@Value("${client.followRedirects}")
	private Boolean followRedirects;
	
	public String postSatispayAuth(String body) {
		
		LOGGER.debug("start postSatispayAuth");
		AuthServiceClient client= FactoryRestClient.createClient(
				AuthServiceClient.class,
				satispayAuthenticationServiceClientPath, 
				new CustomErrorDecoder(),
				connectTimeout, connectTimeoutUnit, readTimeout, readTimeoutUnit, followRedirects);
		
		try {
			String b = client.getBodySatispatAuthorization("{\"hello\": \"world\"}", 
					"staging.authservices.satispay.com", 
					"dom,6 set 2020 12:31:00 CEST", 
					"SHA-256=X48E9qOokqqrvdts8nOJRJN3OWDUoyWxBf7kbu9DBPE=", 
					"Signature keyId=\"signature-test-66289\", algorithm=\"rsa-sha256\", headers=\"(request-target) host date digest\", signature=\"fz5PTHRd09jrLObH5SeMeSZTf8/B1I/cXoWPJP32wlXaAAYE1aK4ZX9HgPSdH0BLJuCN6ddyfrhbpOS2zu6Pb5eYVGjf6950NZvDnI7vi6YeWcoPVH/3P/Y4n5ZUeL9ROgKRx9mvWPJz9fyNiXTeYMNoGIYhYK8F7yEU+Ei2Pyw6B0Ko2JIJcLC4tcwVF1x/gBCJxxEoOkzOhg4VtmjRCw+we0Dry4+J5xeforki5nDPbFgnonk7yww+9/H/ncYDzVs4F8RrvhV/9VWtK63uWC+0+3I2zGcO7ksq4Am8TtTov/BfYqao0939RWmAZgLK3Ke3bPi6cjfRJ4pxJzKngg==\"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
