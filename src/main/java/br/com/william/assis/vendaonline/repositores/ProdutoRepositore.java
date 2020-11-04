package br.com.william.assis.vendaonline.repositores;

import br.com.william.assis.vendaonline.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositore extends JpaRepository<Produto, Integer> {
}
