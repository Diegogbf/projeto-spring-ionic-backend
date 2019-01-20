package br.com.projeto.meu;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.projeto.meu.domain.Categoria;
import br.com.projeto.meu.domain.Cidade;
import br.com.projeto.meu.domain.Cliente;
import br.com.projeto.meu.domain.Endereco;
import br.com.projeto.meu.domain.Estado;
import br.com.projeto.meu.domain.ItemPedido;
import br.com.projeto.meu.domain.Pagamento;
import br.com.projeto.meu.domain.PagamentoComBoleto;
import br.com.projeto.meu.domain.PagamentoComCartao;
import br.com.projeto.meu.domain.Pedido;
import br.com.projeto.meu.domain.Produto;
import br.com.projeto.meu.domain.enums.EstadoPagamento;
import br.com.projeto.meu.domain.enums.TipoCliente;
import br.com.projeto.meu.repositories.CategoriaRepository;
import br.com.projeto.meu.repositories.CidadeRepository;
import br.com.projeto.meu.repositories.ClienteRepository;
import br.com.projeto.meu.repositories.EnderecoRepository;
import br.com.projeto.meu.repositories.EstadoRepository;
import br.com.projeto.meu.repositories.ItemPedidoRepository;
import br.com.projeto.meu.repositories.PagamentoRepository;
import br.com.projeto.meu.repositories.PedidoRepository;
import br.com.projeto.meu.repositories.ProdutoRepository;

@SpringBootApplication
public class PrimeiroprojetospringApplication implements CommandLineRunner {
	

	
	public static void main(String[] args) {
		SpringApplication.run(PrimeiroprojetospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}

}

