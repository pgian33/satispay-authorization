package it.satispay.signature.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.satispay.signature.service.SatispayAuthService;

@Component
@RestController
@RequestMapping(value = "/")
public class SatispayAuthController {
	
	@Autowired
	private SatispayAuthService satispayAuthService;
	private static final Logger LOGGER = LoggerFactory.getLogger(SatispayAuthController.class);

	@PostMapping(value = "/authorize-satispay")
	public ResponseEntity<?> postSatispayAuth(String body) {
		String response = "";
		try {
			response = satispayAuthService.postSatispayAuth(body);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
