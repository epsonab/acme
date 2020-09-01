package ro.acme.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class InfoModel {

	private String message;

	private String ldapUser;

	private String ldapPassword;

	private Map<String, String> headers = new HashMap<>();

	private String certificate;

}
