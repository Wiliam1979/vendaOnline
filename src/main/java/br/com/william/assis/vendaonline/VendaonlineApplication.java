package br.com.william.assis.vendaonline;

import br.com.william.assis.vendaonline.domain.Categoria;
import br.com.william.assis.vendaonline.repositores.CategoriaRepositore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class VendaonlineApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepositore categoriaRepositore;

	public static void main(String[] args) {
		SpringApplication.run(VendaonlineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório" );

		categoriaRepositore.saveAll(Arrays.asList(cat1, cat2));

	}
}
