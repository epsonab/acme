package ro.acme.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	@ConfigurationProperties(prefix = "commonprops")
	public AcmeCommonProperties commonPropertie() {
		return new AcmeCommonProperties();
	}

	@Bean
	@ConfigurationProperties(prefix = "ldap")
	public AcmeLdapProperties ldapProperties() {
		return new AcmeLdapProperties();
	}

}
