package br.com.william.assis.vendaonline.service;


import br.com.william.assis.vendaonline.domain.Categoria;
import br.com.william.assis.vendaonline.domain.Cliente;
import br.com.william.assis.vendaonline.dto.ClienteDTO;
import br.com.william.assis.vendaonline.repositores.ClienteRepositore;
import br.com.william.assis.vendaonline.service.exception.DataIntegrityException;
import br.com.william.assis.vendaonline.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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


    public Cliente update(Cliente obj){
       Cliente newObj = find(obj.getId());
       updateData(newObj, obj);
        return repo.save(newObj);

    }

    public Cliente fromDTO(ClienteDTO objDto){
        return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
    }
      private void updateData(Cliente newObj, Cliente obj){
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
      }

       public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não foi possivel excluir o cliente porque ha entidade realacionadas");
        }

       }

       public List<Cliente> findAll(){
        return repo.findAll();
       }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }
}