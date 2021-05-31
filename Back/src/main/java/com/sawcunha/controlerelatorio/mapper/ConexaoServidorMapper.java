package com.sawcunha.controlerelatorio.mapper;

import com.sawcunha.controlerelatorio.model.ConexaoServidor;
import com.sawcunha.controlerelatorio.model.dto.ConexaoServidorDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConexaoServidorMapper {

    ConexaoServidorDTO conexaoToConexaoDTO(ConexaoServidor conexaoServidor);
    List<ConexaoServidorDTO> conexoesToConexoesDTO(List<ConexaoServidor> conexoesServidor);
    ConexaoServidor conexaoDTOToConexao(ConexaoServidorDTO conexaoServidorDTO);

}
