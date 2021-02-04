package br.com.william.assis.vendaonline.service;

import br.com.william.assis.vendaonline.domain.Cliente;
import br.com.william.assis.vendaonline.domain.Pedido;
import br.com.william.assis.vendaonline.repositores.PedidoRepositore;
import br.com.william.assis.vendaonline.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

@Autowired
private PedidoRepositore pedidoRepositore;

    public Pedido find(Integer id){
        Optional<Pedido> obj = pedidoRepositore.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo:" + Pedido.class.getName()));


    }
}
