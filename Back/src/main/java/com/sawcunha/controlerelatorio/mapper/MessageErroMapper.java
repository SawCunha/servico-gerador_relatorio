package com.sawcunha.controlerelatorio.mapper;

import com.sawcunha.controlerelatorio.model.MessageErro;
import com.sawcunha.controlerelatorio.model.dto.MessageErroDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageErroMapper {

    MessageErroDTO mensagemToMensagemDTO(MessageErro messageErro);

}
