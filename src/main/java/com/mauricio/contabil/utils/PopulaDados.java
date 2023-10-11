package com.mauricio.contabil.utils;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

//import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mauricio.contabil.domain.Cadastro;
import com.mauricio.contabil.domain.Categoria;
import com.mauricio.contabil.domain.Cidade;
import com.mauricio.contabil.domain.ClasseCad;
import com.mauricio.contabil.domain.Cliente;
import com.mauricio.contabil.domain.Endereco;
import com.mauricio.contabil.domain.Estado;
import com.mauricio.contabil.domain.Funcionario;
import com.mauricio.contabil.domain.PagCartao;
import com.mauricio.contabil.domain.PagPix;
import com.mauricio.contabil.domain.Pagamento;
import com.mauricio.contabil.domain.Produto;
import com.mauricio.contabil.domain.Servico;
import com.mauricio.contabil.domain.TipoCad;
import com.mauricio.contabil.domain.enums.SituacaoPagamento;
import com.mauricio.contabil.repository.CadastroRepository;
import com.mauricio.contabil.repository.CategoriaRepository;
import com.mauricio.contabil.repository.CidadeRepository;
import com.mauricio.contabil.repository.ClasseCadRepository;
import com.mauricio.contabil.repository.EnderecoRepository;
import com.mauricio.contabil.repository.EstadoRepository;
import com.mauricio.contabil.repository.PagamentoRepository;
import com.mauricio.contabil.repository.PessoaRepository;
import com.mauricio.contabil.repository.ProdutoRepository;
import com.mauricio.contabil.repository.ServicoRepository;
import com.mauricio.contabil.repository.TipoCadRepository;

@Component
public class PopulaDados {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	TipoCadRepository tipocadRepository;
	
	@Autowired
	ClasseCadRepository classecadRepository;
	
	@Autowired
	CadastroRepository cadastroRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	
//	@PostConstruct //somente utilizar em bd virtual
public void cadastrar() throws ParseException  {
		
		Categoria cat1 = new Categoria(null, "Serviço");
		Categoria cat2 = new Categoria(null, "Orçamento");
	
		
		
		Produto p1 = new Produto(null, "Solicitar regularização de CPF", 100.0);
		Produto p2 = new Produto(null, "Solicitar regularização do CNPJ", 200.0);
		Produto p3 = new Produto(null, "solicitar abertura de MEI", 300.0);
		Produto p4 = new Produto(null, "solicitar orçamento", 0.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p4));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		
		TipoCad tipocad1 = new TipoCad(null, "CPF");
		TipoCad tipocad2 = new TipoCad(null, "CNPJ");
		
		ClasseCad classecad1 = new ClasseCad(null, "Física");
		ClasseCad classecad2 = new ClasseCad(null, "MEI");
		ClasseCad classecad3 = new ClasseCad(null, "Simples Nacional");
		
		Cadastro cad1 = new Cadastro(null, "Pessoa Teste", 1234567890, tipocad1, classecad1);
		Cadastro cad2 = new Cadastro(null, "MEI Teste", 000111222333, tipocad2, classecad2);
		Cadastro cad3 = new Cadastro(null, "Empresa Teste", 000222333444, tipocad2, classecad3);
		
		tipocadRepository.saveAll(Arrays.asList(tipocad1, tipocad2));
		classecadRepository.saveAll(Arrays.asList(classecad1, classecad2, classecad3));
		
		cadastroRepository.saveAll(Arrays.asList(cad1, cad2, cad3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Belo Horizonte", est1);
		Cidade c2 = new Cidade(null, "Capelinha", est1);
		Cidade c3 = new Cidade(null, "São Paulo", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente clt1 = new Cliente(null, "Jose Maria", "jose@mail.com", "FISICA"); //Cliente clt1 = new Cliente(null, "Jose Maria", "jose@mail.com", "335.194.320-21", "FISICA");
		clt1.getTelefones().addAll(Arrays.asList("3516-2000","9191-0000"));
		
		Funcionario fnc1 = new Funcionario(null, "Maria Jose", "maria@mail.com", "ATENDENTE"); //Funcionario fnc1 = new Funcionario(null, "Maria Jose", "maria@mail.com", "551.872.200.12", "ATENDENTE");
		fnc1.getTelefones().addAll(Arrays.asList("3279-0001","9090-0002"));
		
		
		Endereco end1 = new Endereco(null, "Rua Tupis", "500", "Apto 101", "Pindorama", "30111222", clt1, c1);
		Endereco end2 = new Endereco(null, "Av. Tamoios", "100", "Casa", "Oca", "3968000", fnc1, c2);
		Endereco end3 = new Endereco(null, "Rua Aranãs", "10", "Apto 201", "Centro", "01153000", fnc1, c3);
		
		pessoaRepository.saveAll(Arrays.asList(clt1, fnc1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Servico srv1 = new Servico(null, sdf.parse("02/09/2021 09:00"), sdf.parse("02/09/2021 12:00"), "Tosa", clt1, fnc1, cad1);
		Servico srv2 = new Servico(null, sdf.parse("03/09/2021 12:00"), sdf.parse("04/09/2021 12:00"), "Hotel", clt1, fnc1,cad2);
		Servico srv3 = new Servico(null, sdf.parse("05/09/2021 16:00"), sdf.parse("05/09/2021 16:30"), "Vermifugação", clt1, fnc1, cad3);
		
		
		Pagamento pgt1 = new PagCartao(null, 60.00, SituacaoPagamento.QUITADO,srv2, 6);
		srv2.setPagamento(pgt1);
		
		Pagamento pgt2 = new PagPix(null, 100.0, SituacaoPagamento.PENDENTE, srv1,  sdf.parse("02/09/2021 00:00"), null);
		srv1.setPagamento(pgt2);
		
		Pagamento pgt3 = new PagPix(null, 75.00, SituacaoPagamento.QUITADO, srv3, sdf.parse("05/09/2021 16:30"), null);
		srv3.setPagamento(pgt3);
		
		clt1.getServicos().addAll(Arrays.asList(srv1, srv2));
		fnc1.getServicos().addAll(Arrays.asList(srv1, srv2));
		
		
		srv2.getProdutos().addAll(Arrays.asList(p1, p2, p4));
		srv3.getProdutos().addAll(Arrays.asList(p3));
		
		
		servicoRepository.saveAll(Arrays.asList(srv1, srv2, srv3));
		pagamentoRepository.saveAll(Arrays.asList(pgt1, pgt2, pgt3));
		
		
		
		
}
}
