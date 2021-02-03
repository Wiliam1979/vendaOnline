package br.com.william.assis.vendaonline.repositores;

import br.com.william.assis.vendaonline.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepositores extends JpaRepository<ItemPedido, Integer> {
}
