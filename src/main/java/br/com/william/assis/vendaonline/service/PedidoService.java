package br.com.william.assis.vendaonline.service;

import br.com.william.assis.vendaonline.domain.Cliente;
import br.com.william.assis.vendaonline.domain.ItemPedido;
import br.com.william.assis.vendaonline.domain.PagamentoComBoleto;
import br.com.william.assis.vendaonline.domain.Pedido;
import br.com.william.assis.vendaonline.domain.enums.EstadoPagamento;
import br.com.william.assis.vendaonline.repositores.ItemPedidoRepositores;
import br.com.william.assis.vendaonline.repositores.PagamentoRepositore;
import br.com.william.assis.vendaonline.repositores.PedidoRepositore;
import br.com.william.assis.vendaonline.repositores.ProdutoRepositore;
import br.com.william.assis.vendaonline.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class PedidoService {

@Autowired
private PedidoRepositore pedidoRepositore;

@Autowired
private BoletoService boletoService;

@Autowired
private PagamentoRepositore pagamentoRepositore;

@Autowired
private ProdutoRepositore produtoRepositore;

@Autowired
private ProdutoService produtoService;

@Autowired
private ItemPedidoRepositores itemPedidoRepositore;


    public Pedido find(Integer id){
        Optional<Pedido> obj = pedidoRepositore.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo:" + Pedido.class.getName()));


    }
    @Transactional
    public Pedido insert(Pedido obj){
        obj.setId(null);
        obj.setInstante(new Date());
        obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if (obj.getPagamento()instanceof PagamentoComBoleto){
            PagamentoComBoleto pagto = (PagamentoComBoleto)obj.getPagamento();
            boletoService.preencherPagamentocomBoleto(pagto,obj.getInstante());
        }
        obj = pedidoRepositore.save(obj);
        pagamentoRepositore.save(obj.getPagamento());
        for(ItemPedido ip : obj.getItens()){
            ip.setDesconto(0.0);
            ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());
            ip.setPedido(obj);
        }
        itemPedidoRepositore.saveAll(obj.getItens());
        return obj;
    }
}
