package it.satispay.signature.client;

import feign.Response;
import feign.codec.ErrorDecoder;
import it.satispay.signature.exception.IntegrationException;

public class CustomErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {

		return new IntegrationException(methodKey +" : " + "httpStatusErr: "  +   response.status());
	
	} 

}
