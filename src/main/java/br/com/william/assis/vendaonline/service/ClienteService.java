package br.com.william.assis.vendaonline.service;

import br.com.william.assis.vendaonline.domain.Categoria;
import br.com.william.assis.vendaonline.domain.Cliente;
import br.com.william.assis.vendaonline.repositores.CategoriaRepositore;
import br.com.william.assis.vendaonline.repositores.ClienteRepositore;
import br.com.william.assis.vendaonline.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositore repo;

    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo:" + Cliente.class.getName()));

    }
}