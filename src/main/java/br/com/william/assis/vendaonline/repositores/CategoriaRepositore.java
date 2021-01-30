package br.com.william.assis.vendaonline.repositores;

import br.com.william.assis.vendaonline.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositore extends JpaRepository<Categoria, Integer> {
}
