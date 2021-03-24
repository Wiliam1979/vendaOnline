package br.com.william.assis.vendaonline.service;

import br.com.william.assis.vendaonline.domain.Cliente;
import br.com.william.assis.vendaonline.domain.ItemPedido;
import br.com.william.assis.vendaonline.domain.PagamentoComBoleto;
import br.com.william.assis.vendaonline.domain.Pedido;
import br.com.william.assis.vendaonline.domain.enums.EstadoPagamento;
import br.com.william.assis.vendaonline.repositores.*;
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

@Autowired
private ClienteService clienteService;


    public Pedido find(Integer id){
        Optional<Pedido> obj = pedidoRepositore.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo:" + Pedido.class.getName()));


    }
    @Transactional
    public Pedido insert(Pedido obj){
        obj.setId(null);
        obj.setInstante(new Date());
        obj.setCliente(clienteService.find(obj.getCliente().getId()));
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
            ip.setProduto(produtoService.find(ip.getProduto().getId()));
            ip.setPreco(ip.getProduto().getPreco());
            ip.setPedido(obj);
        }
        itemPedidoRepositore.saveAll(obj.getItens());
        System.out.println(obj);
        return obj;
    }
}
