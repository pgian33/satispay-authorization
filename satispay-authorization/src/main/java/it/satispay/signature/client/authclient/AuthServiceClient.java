package it.satispay.signature.client.authclient;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface AuthServiceClient {

	@RequestLine("POST /wally-services/protocol/tests/signature")
	@Headers({"Accept:application/json", 
			"Content-Type:application/json", 
			"Host:{host}",
			"date:{date}",
			"digest:{digest}",
			"Authorization:{authorization}"})
	String getBodySatispatAuthorization(String body,  
			@Param("host") String host, 
			@Param("date") String date, 
			@Param("digest") String digest,
			@Param("authorization") String authorization) throws Exception;
}
