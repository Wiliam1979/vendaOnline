package br.com.william.assis.vendaonline.repositores;

import br.com.william.assis.vendaonline.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepositore extends JpaRepository<Estado, Integer> {
}
