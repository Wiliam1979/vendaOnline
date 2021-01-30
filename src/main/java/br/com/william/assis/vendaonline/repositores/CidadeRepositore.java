package br.com.william.assis.vendaonline.repositores;

import br.com.william.assis.vendaonline.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepositore extends JpaRepository<Cidade, Integer> {
}
