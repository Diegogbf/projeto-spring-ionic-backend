package br.com.projeto.meu.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.projeto.meu.services.DBService;
import br.com.projeto.meu.services.EmailService;
import br.com.projeto.meu.services.MockEmailService;
import br.com.projeto.meu.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instanciaDatabase() throws ParseException {
		if(!"create".equals(strategy)) {
			return false;
		}
		dbService.instanciaDbTest();
		return true;
	}
	
	@Bean
	public EmailService emailService(){
		return new SmtpEmailService();
	}
}
