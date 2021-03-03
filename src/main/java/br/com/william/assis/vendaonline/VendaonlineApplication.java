package br.com.william.assis.vendaonline;

import br.com.william.assis.vendaonline.domain.*;
import br.com.william.assis.vendaonline.domain.enums.EstadoPagamento;
import br.com.william.assis.vendaonline.domain.enums.TipoCliente;
import br.com.william.assis.vendaonline.repositores.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class VendaonlineApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(VendaonlineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}