package br.com.william.assis.vendaonline.service.validation;

import br.com.william.assis.vendaonline.domain.Cliente;
import br.com.william.assis.vendaonline.domain.enums.TipoCliente;
import br.com.william.assis.vendaonline.dto.ClienteNewDTO;
import br.com.william.assis.vendaonline.repositores.ClienteRepositore;
import br.com.william.assis.vendaonline.resources.exception.FieldMessage;
import br.com.william.assis.vendaonline.service.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    private ClienteRepositore repo;

    @Override
    public void initialize(ClienteInsert ann) {
    }
    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

         if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod())&& !BR.isValidCPF(objDto.getCpfOuCnpj())){
             list.add(new FieldMessage("cpfOuCnpj", "CPF invalido"));
         }

        if(objDto.getTipo().equals(TipoCliente.PESSOAJURITICA.getCod())&& !BR.isValidCNPJ(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ invalido"));
        }
           Cliente aux = repo.findByEmail(objDto.getEmail());
        if(aux != null){
            list.add(new FieldMessage("email", "Email já existente"));
        }

        // inclua os testes aqui, inserindo erros na lista
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
