package br.com.william.assis.vendaonline;

import br.com.william.assis.vendaonline.domain.Categoria;
import br.com.william.assis.vendaonline.domain.Produto;
import br.com.william.assis.vendaonline.repositores.CategoriaRepositore;
import br.com.william.assis.vendaonline.repositores.ProdutoRepositore;
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

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));



        categoriaRepositore.saveAll(Arrays.asList(cat1, cat2));
        produtoRepositore.saveAll(Arrays.asList(p1, p2, p3));

	}
}
