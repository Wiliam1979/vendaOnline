package br.com.william.assis.vendaonline.repositores;

import br.com.william.assis.vendaonline.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositore extends JpaRepository <Cliente, Integer>{
}
