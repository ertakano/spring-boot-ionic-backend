package br.erico.cursomc;

import br.erico.cursomc.domain.*;
import br.erico.cursomc.domain.enums.TipoCliente;
import br.erico.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado mg = new Estado(null, "MG");
		Estado sp = new Estado(null, "SP");

		Cidade uberlandia = new Cidade(null, "Uberlândia", mg);
		Cidade saoPaulo = new Cidade(null, "São Paulo", sp);
		Cidade campinas = new Cidade(null, "Campinas", sp);

		mg.getCidades().addAll(Arrays.asList(uberlandia));
		sp.getCidades().addAll(Arrays.asList(saoPaulo, campinas));

		estadoRepository.saveAll(Arrays.asList(mg, sp));
		cidadeRepository.saveAll(Arrays.asList(uberlandia, saoPaulo, campinas));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "363789123770", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("987654321", "921654987"));
		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, uberlandia);
		Endereco end2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, saoPaulo);
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));

	}

}
