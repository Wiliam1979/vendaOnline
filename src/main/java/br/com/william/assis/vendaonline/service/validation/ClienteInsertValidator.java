package br.com.william.assis.vendaonline.service.validation;

import br.com.william.assis.vendaonline.domain.enums.TipoCliente;
import br.com.william.assis.vendaonline.dto.ClienteNewDTO;
import br.com.william.assis.vendaonline.resources.exception.FieldMessage;
import br.com.william.assis.vendaonline.service.validation.utils.BR;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
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

        // inclua os testes aqui, inserindo erros na lista
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
