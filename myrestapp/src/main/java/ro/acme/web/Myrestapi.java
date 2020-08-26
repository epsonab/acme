package ro.acme.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.acme.config.AcmeLdapProperties;
import ro.acme.model.InfoModel;

@RestController
@RequestMapping(path = "/acme")
public class Myrestapi {

	@Autowired
	private AcmeLdapProperties ldapProperties;

	@GetMapping(path = "/appinfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InfoModel> appInfo() {

		String msg = "Hello";

		InfoModel im = new InfoModel();
		im.setMessage(msg);
		im.setLdapUser(ldapProperties.getUser());
		im.setLdapPassword(ldapProperties.getPassword());

		return new ResponseEntity<>(im, HttpStatus.OK);

	}

}
