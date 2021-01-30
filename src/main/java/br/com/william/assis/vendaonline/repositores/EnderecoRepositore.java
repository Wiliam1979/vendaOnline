package br.com.william.assis.vendaonline.repositores;

import br.com.william.assis.vendaonline.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepositore extends JpaRepository<Endereco, Integer> {
}
