package br.com.william.assis.vendaonline.service;

import java.util.Optional;

import br.com.william.assis.vendaonline.domain.Categoria;
import br.com.william.assis.vendaonline.repositores.CategoriaRepositore;
import br.com.william.assis.vendaonline.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepositore repo;

    public Categoria find(Integer id) {
        Optional<Categoria>obj=repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " +id+ ", Tipo:" +Categoria.class.getName()));

    }
    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria obj){
        find(obj.getId());
        return repo.save(obj);
    }

}