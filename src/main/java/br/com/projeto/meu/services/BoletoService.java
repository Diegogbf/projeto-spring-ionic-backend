package br.com.projeto.meu.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.projeto.meu.domain.PagamentoComBoleto;

@Service
public class BoletoService {
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instante) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}
}
