package ro.acme.model;

import lombok.Data;

@Data
public class InfoModel {

	private String message;
	
	private String ldapUser;
	
	private String ldapPassword;

}
