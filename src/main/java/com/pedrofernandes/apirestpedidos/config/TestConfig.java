package com.pedrofernandes.apirestpedidos.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pedrofernandes.apirestpedidos.domain.Categoria;
import com.pedrofernandes.apirestpedidos.domain.Cidade;
import com.pedrofernandes.apirestpedidos.domain.Cliente;
import com.pedrofernandes.apirestpedidos.domain.Endereco;
import com.pedrofernandes.apirestpedidos.domain.Estado;
import com.pedrofernandes.apirestpedidos.domain.Pagamento;
import com.pedrofernandes.apirestpedidos.domain.PagamentoComBoleto;
import com.pedrofernandes.apirestpedidos.domain.PagamentoComCartao;
import com.pedrofernandes.apirestpedidos.domain.Pedido;
import com.pedrofernandes.apirestpedidos.domain.Produto;
import com.pedrofernandes.apirestpedidos.domain.enums.EstadoPagamento;
import com.pedrofernandes.apirestpedidos.domain.enums.TipoCliente;
import com.pedrofernandes.apirestpedidos.repositories.CategoriaRepository;
import com.pedrofernandes.apirestpedidos.repositories.CidadeRepository;
import com.pedrofernandes.apirestpedidos.repositories.ClienteRepository;
import com.pedrofernandes.apirestpedidos.repositories.EnderecoRepository;
import com.pedrofernandes.apirestpedidos.repositories.EstadoRepository;
import com.pedrofernandes.apirestpedidos.repositories.ProdutoRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().add(p2);

		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().add(cat1);

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().add(c1);
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Pedro", "pedro@email.com", "293180392", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("2313919238", "818328389"));

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38291300", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38732918", cli1, c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);

		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
	}
}
