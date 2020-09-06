package it.satispay.signature.client;

import org.springframework.stereotype.Component;

import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

@Component
public class FactoryRestClient {


	public final static <T> T createClient(
			Class<T> typeClient, 
			String uri, 
			ErrorDecoder typeErrorDecode,
			Long connectTimeout, 
			String connectTimeoutUnit, 
			Long readTimeout, 
			String readTimeoutUnit, 
			Boolean followRedirects 
			) {


		return Feign.builder()
				.client(new OkHttpClient())
				.options(new Request.Options(
						connectTimeout, 
						GiveTimeOut.from(connectTimeoutUnit),
						readTimeout, 
						GiveTimeOut.from(readTimeoutUnit),
						followRedirects
						))
				.errorDecoder(typeErrorDecode)
				.logger(new Slf4jLogger(typeClient))
				.logLevel(Logger.Level.FULL)
				.target(typeClient, uri);
	}
}

