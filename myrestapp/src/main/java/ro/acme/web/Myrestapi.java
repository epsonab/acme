package ro.acme.web;

import java.security.cert.X509Certificate;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.acme.config.AcmeCommonProperties;
import ro.acme.config.AcmeLdapProperties;
import ro.acme.model.InfoModel;

@RestController
@RequestMapping(path = "/acme")
public class Myrestapi {

	@Autowired
	private AcmeLdapProperties ldapProperties;

	@Autowired
	private AcmeCommonProperties commonProperties;

	@GetMapping(path = "/appinfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InfoModel> appInfo(@RequestHeader Map<String, String> headers, HttpServletRequest request) {

		InfoModel im = new InfoModel();
		im.setMessage(commonProperties.getMessage());

		im.setLdapUser(ldapProperties.getUser());
		im.setLdapPassword(ldapProperties.getPassword());
		Map<String, String> msgHeaders = im.getHeaders();

		headers.forEach((key, value) -> {
			msgHeaders.put(key, value);
		});
		
		
		

		X509Certificate[] certificates = (X509Certificate[]) request
				.getAttribute("javax.servlet.request.X509Certificate");

		if (certificates != null && certificates.length > 0) {
			im.setCertificate(certificates[0].toString());
		}

		return new ResponseEntity<>(im, HttpStatus.OK);
	}

}
