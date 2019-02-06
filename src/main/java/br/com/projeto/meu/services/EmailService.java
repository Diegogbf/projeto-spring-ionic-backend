package br.com.projeto.meu.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.projeto.meu.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmation(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
