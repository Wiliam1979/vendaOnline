package br.com.william.assis.vendaonline.repositores;

import br.com.william.assis.vendaonline.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepositore extends JpaRepository <Cliente, Integer>{

    @Transactional(readOnly = true)
    Cliente findByEmail(String email);
}
