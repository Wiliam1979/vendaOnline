package br.com.william.assis.vendaonline;

import br.com.william.assis.vendaonline.domain.*;
import br.com.william.assis.vendaonline.domain.enums.TipoCliente;
import br.com.william.assis.vendaonline.repositores.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class VendaonlineApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepositore categoriaRepositore;
	@Autowired
	private ProdutoRepositore produtoRepositore;

	@Autowired
	private EstadoRepositore estadoRepositore;

	@Autowired

	private CidadeRepositore cidadeRepositore;

	@Autowired
	private ClienteRepositore clienteRepositore;

	@Autowired
	private EnderecoRepositore enderecoRepositore;


	public static void main(String[] args) {
		SpringApplication.run(VendaonlineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório" );

		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00 );

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);




		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));




        categoriaRepositore.saveAll(Arrays.asList(cat1, cat2));
        produtoRepositore.saveAll(Arrays.asList(p1, p2, p3));
        estadoRepositore.saveAll(Arrays.asList(est1, est2));
        cidadeRepositore.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cli1 = new Cliente(null,"Maria silva", "maria@gmail.com","36378912377", TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("58128003", "980383950"));

         Endereco e1 = new Endereco(null,"Rua Flores","300","apto 203","Jardim","38220834",cli1, c1);

         Endereco e2 = new Endereco(null, "Rua Avenida Matos ","105","sala 800","Centro","38877012",cli1,c2);

         cli1.getEnderecos().addAll(Arrays.asList(e1, e2));


         clienteRepositore.saveAll(Arrays.asList(cli1));
         enderecoRepositore.saveAll(Arrays.asList(e1, e2));


	}
}
