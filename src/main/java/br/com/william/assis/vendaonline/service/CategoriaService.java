package br.com.william.assis.vendaonline.service;

import br.com.william.assis.vendaonline.domain.Categoria;
import br.com.william.assis.vendaonline.repositores.CategoriaRepositore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepositore repo;

    public Categoria find(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElse(null);

    }
}
